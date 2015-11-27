//package com.boot.service.impl;
//
//import static org.junit.Assert.fail;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoOperations;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.core.query.Update;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.boot.entity.mongo.Account2;
//import com.boot.entity.mongo.Friends;
//import com.boot.entity.mongo.Group;
//import com.boot.entity.mongo.Person;
//import com.boot.entity.mongo.User;
//import com.boot.service.iface.IFriendCircle;
//
///**
//*@Auth						jay
//*@date						2015年11月26日 上午10:23:50
//*/
//@RunWith(SpringJUnit4ClassRunner.class) 
//@ContextConfiguration(locations={ "classpath:META-INF/spring/applicationContext.xml", 
//		"classpath:META-INF/spring/applicationContext-jpa.xml",
//		"classpath:META-INF/spring/applicationContext-mybatis.xml",
//		"classpath:META-INF/spring/applicationContext-mongo.xml"})
//public class FirendCircleTest {
//
//	private Logger logger = LoggerFactory.getLogger(FirendCircleTest.class); 
//	
//	@Autowired
//	IFriendCircle friendCircle;
//	
//	@Autowired
//	MongoTemplate mongoTemplate;
//	
//	@Autowired
//	MongoOperations mongoOperations;
//	
//	/**
//	 * 添加成员
//	 */
//	//@Ignore
//	@Test
//	public void testAddUser() {
//		logger.info("add user");
//		mongoTemplate.save(new User("Jay", "picture1"));
//		mongoTemplate.save(new User("Jack", "picture2"));
//		mongoTemplate.save(new User("Mike", "picture3"));
//		mongoTemplate.save(new User("Sean", "picture4"));
//	}
//	
//	/**
//	 * 添加好友
//	 */
//	@Test
//	@Transactional
//	public void testAddFriend() {
//		String userId = "565704aa77da781e71e1807b";//jay
//		//String addedUserId = "56567084e4b02efa27316570";//jack
//		String addedUserId = "565704aa77da781e71e1807c";//mike
//		//String addedUserId = "56567084e4b02efa27316572";//seal  添加
//		
//		Query query = new Query();
//		query.addCriteria(Criteria.where("userId").is(userId));//Jay
//		Friends friends = mongoTemplate.findOne(query, Friends.class);
//		
//		// 人
//		User user = mongoTemplate.findOne(new Query(Criteria.where("id").is(addedUserId)), User.class);
//		
//		if(friends == null){
//			
//			
//			
//			// 组
//			Group group = new Group();
//			group.setName("我的好友");
//			List<User> users = new ArrayList<User>();
//			users.add(user);
//			group.setUsers(users);
//			
//			mongoTemplate.save(group);
//			
//			// 关系表
//			friends = new Friends();
//			friends.setUserId(userId);
//			List<Group> groups = new ArrayList<Group>();
//			groups.add(group);
//			friends.setGroupList(groups);
//
//			mongoTemplate.save(friends);
//			
//		}else{
//			List<Group> groups  = friends.getGroupList();
//			// 查找并修改
//			for (int i = 0; i < groups.size(); i++) {
//				if(groups.get(i).getId().equals("5656bb1be4b0503479000630")){//组id传进来
//					List<User> users = groups.get(i).getUsers();
//					users.add(user);
////					groups.get(i).setUsers(users);
////					List<Group> groupList = new ArrayList<Group>();
//					Group g = groups.get(i);
//					g.setUsers(users);
//					groups.set(i, g);
//					
//					mongoTemplate.save(g);
//					
//				}
//			}
//
//			friends.setGroupList(groups);
//			logger.info(friends.toString());
//			mongoTemplate.save(friends);
//		}
//
//	}
//	
//	/**
//	 * 根据 id获取好友
//	 */
//	@Test
//	@Transactional
//	public void testGetFriend() {
//		Friends friends = mongoTemplate.findOne(new Query(Criteria.where("userId").is( "565704aa77da781e71e1807b")),Friends.class);
//		logger.info("result: " + friends.toString());
//	}
//	
//	
//	@Test
//	public void testPost() {
//		friendCircle.post();
//	}
//
//	@Test
//	public void testGetDynamic() {
//		fail("Not yet implemented");
//	}
//
//	
//	@Test
//	public void one2many() {
//		
//		Person persion = new Person();
//		persion.setSsn(1);
//		
//		List<Account2> accounts = new ArrayList<Account2>();
//		
//		Account2 account = new Account2();
//		//account.setId("1111111");
//		account.setTotal(11.0f);
//		mongoTemplate.save(account);
//		
//		Account2 account2 = new Account2();
//		//account2.setId("1111122");
//		account2.setTotal(11.0f);
//		mongoTemplate.save(account2);
//		
//		accounts.add(account);
//		accounts.add(account2);
//		
//	
//		persion.setAccounts(accounts);
//		
//		mongoTemplate.save(persion);
//	}
//	
//	@Test
//	public void getList() {
//		List<Person>  list = mongoTemplate.find(new Query(), Person.class);
//		logger.info(list.toString());
//	}
//	
//	/**
//	 * 关联查询
//	 */
//	@Test
//	public void getList2() {
//		Query query =  new Query();
//		query.addCriteria(Criteria.where("total").gt(10));
//		
//		List<Person>  list = mongoTemplate.find(query, Person.class);
//		logger.info("result: " +list.toString());
//	}
//	
//	@Test
//	public void updateAccount() {
//		Query query = new Query();
//		query.addCriteria(Criteria.where("id").is("5656b035e4b0ecea577b59d5"));
//		Update update = new Update();
//		//update.inc("total",99.99f);
//		update.set("total",99.99f);
//		//update.addToSet("total", 11.2);
//		mongoTemplate.findAndModify(query, update, Account2.class);
//	}
//	
//	
//	@Test
//	public void mongoOperations() {
//		logger.info("mongoOperations");
//		String mapFunction = "";
//		String  reduceFunction = "";
//		mongoOperations.mapReduce("User", mapFunction, reduceFunction, User.class);
//	}
//}

package com.boot.service.iface;

import com.boot.vo.AccountVo;
import com.boot.vo.common.ResultVo;

/** 
* @ClassName: 		IAccountService 
* @Description: 	
* @author 			Jay
* @date 			2015年11月26日 下午9:30:46  
*/
public interface IAccountService {

	/**
	 * add account
	 * @param accountVo
	 * @return
	 */
	public ResultVo addAccount(AccountVo accountVo);
	
	/**
	 * login
	 * @param accountVo
	 * @return
	 */
	public ResultVo login(AccountVo accountVo);
	
}


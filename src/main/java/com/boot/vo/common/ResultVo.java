package com.boot.vo.common;

import java.io.Serializable;

/**
 * @ClassName: ResultVo
 * @Description:
 * @author Jay
 * @date 2015年11月26日 下午9:44:50
 */
public class ResultVo implements Serializable {

	private static final long serialVersionUID = 6085201306650585481L;

	private int code;

	private String info = "";

	public ResultVo() {
	}

	public ResultVo(int code, String info) {
		this.code = code;
		this.info = info;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "ResultVo [code=" + code + ", info=" + info + "]";
	}

}

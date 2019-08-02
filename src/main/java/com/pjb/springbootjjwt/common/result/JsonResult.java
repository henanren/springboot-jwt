package com.pjb.springbootjjwt.common.result;

/**
 * 结果封装
 * @author niucg
 * 2018年8月13日
 */
public class JsonResult<T> {
	/**
	 * code
	 */
	private Integer code = 0;
	/**
	 * 信息
	 */
	private String message = "success";
	/**
	 * 数据体
	 */
	private T data;
	/**
	 * 异常
	 */
	private Throwable throwable;

	/**
	 * 只为序列化，不能使用
	 */
	public JsonResult() {
		super();
	}

	/**
	 * 构造不对外
	 * 
	 * @param code
	 * @param message
	 * @param data
	 * @param throwable
	 */
	private JsonResult(Integer code, String message, T data, Throwable throwable) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
		this.throwable = throwable;
	}

	public JsonResult(String message) {
		super();
		this.message = message;
	}

	/**
	 * 自定义成功信息
	 * 
	 * @描述：
	 * @param
	 * @time ：2017年8月2日 下午6:00:11
	 */
	public static <T> JsonResult<T> success(String message, T data) {
		return new JsonResult<T>(0, message, data, null);
	}

	/**
	 * 
	 * @描述： 默认success成功信息
	 * @param
	 * @author liugj
	 * @time ：2017年8月2日 下午6:01:00
	 */
	public static <T> JsonResult<T> success(T result) {
		return new JsonResult<T>(0, "success", result, null);
	}

	/**
	 * 默认的成功信息，data为空
	 * 
	 * @描述：
	 * @param
	 * @author liugj
	 * @time ：2017年8月2日 下午6:01:50
	 */
	public static <T> JsonResult<T> success() {
		return new JsonResult<T>(0, "success", null, null);
	}

	/**
	 * 无异常信息的时候使用
	 * 
	 * @描述：
	 * @param
	 * @time ：2017年8月2日 下午5:42:14
	 */
	public static <T> JsonResult<T> error(Integer code, String message) {
		return new JsonResult<T>(code, message, null, null);
	}

	/**
	 * 有异常信息的时候
	 *
	 * @描述：
	 * @param
	 * @time ：2017年8月2日 下午6:02:27
	 */
	public static  JsonResult<Void> error(Integer code, String message,
			Throwable ex) {
		return new JsonResult<Void>(code, message, null, ex);
	}

	/**
	 * 只有异常信息的错误
	 * 
	 * @描述：
	 * @param
	 * @time ：2017年8月2日 下午6:25:39
	 */
	public static <T> JsonResult<T> error(Throwable ex) {
		return new JsonResult<T>(500, ex.getMessage(), null, ex);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}

}

package chatting.vo;

import java.io.Serializable;

/**
 * 客户端与服务器进行信息传输的协议类
 * 
 * @author 紫风铃
 *
 * @param <T>
 *            传输的消息的内容所属的类
 */
public class Message<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 消息类型 ，例如register--注册消息 */
	String messageType;
	/** 源id */
	String sourceId;
	/** 目标id */
	String targetId;
	/** 消息状态码 ，用于传达消息处理结果，例如转发失败，接收成功等 */
	String status;
	/** 消息内容所属类型，例如String */
	String contentType;
	/** 消息内容 */
	T content;
	/** 消息校验码，主要用于校验消息内容与消息类型的是否符合规范或是否错误 */
	String checkCode;

	/**
	 * 空构造方法，初始化属性均为null，慎用
	 */
	public Message() {
		super();
	}

	/**
	 * 标准构造方法，建议调用此构造方法，该方法自动完成消息内容所属类型（contentType）的初始化，
	 * 以及消息校验码的生成，注意消息内容如果含有密码等敏感信息，请事先使用MD5工具类进行脱敏处理。
	 * 
	 * @param messageType
	 *            消息类型 ，例如register--注册消息
	 * @param sourceId
	 *            源id
	 * @param targetId
	 *            目标id
	 * @param status
	 *            消息状态码 ，用于传达消息处理结果，例如转发失败，接收成功等
	 * @param content
	 *            消息内容，采用泛型约束，创建对象时必须对泛型初始化
	 */
	public Message(String messageType, String sourceId, String targetId, String status, T content) {
		super();
		this.messageType = messageType;
		this.sourceId = sourceId;
		this.targetId = targetId;
		this.status = status;
		this.content = content;
		this.contentType = this.content.getClass().getName();
		this.checkCode = Integer.toString(content.toString().length() / 2);

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMessageType() {
		return messageType;
	}

	public String getSourceId() {
		return sourceId;
	}

	public String getTargetId() {
		return targetId;
	}

	public String getStatus() {
		return status;
	}

	public String getContentType() {
		return contentType;
	}

	public T getContent() {
		return content;
	}

	public String getCheckCode() {
		return checkCode;
	}

}

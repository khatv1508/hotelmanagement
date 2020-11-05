package hotelmanagement.gui;

public class ResultMessage {
	public static final String DIALOG_INFORM = "Thông báo";
	public static final String ERR_SELECT = "Đã xảy ra lỗi khi thực hiện";
	public static final String MSG_CODE_SUCCESS = "0";
	
	public static final String MSG_LOGIN_SUCCESS = "Login thành công";

	public static final String MSG_CODE_FAIL= "1";
	public static final String MSG_LOGIN_FAIL = "Tài khoản hoặc mật khẩu không đúng";
	
	public String msgCode;
	public String getMsgCode() {
		return msgCode;
	}
	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String content;
}

package hotelmanagement.model;

public class ResultMessage {
	public static final String DIALOG_INFORM = "Thông báo";
	public static final String ERR_SELECT = "Đã xảy ra lỗi khi thực hiện";
	public static final String MSG_CODE_SUCCESS = "0";
	
	public static final String MSG_LOGIN_SUCCESS = "Login thành công";
	
	public static final String MSG_CUSTOMER = "Thêm thành công";
	public static final String MSG_UPDATE_CUSTOMER = "Sửa thành công";
	
	public static final String MSG_ROOM = "Thêm phòng thành công";
	public static final String MSG_UPDATE_ROOM = "Sửa phòng thành công";
	
	public static final String MSG_ADD_ROOM = "Đặt phòng thành công";

	public static final String MSG_CODE_FAIL= "1";
	public static final String MSG_LOGIN_FAIL = "Tài khoản hoặc mật khẩu không đúng";
	
	public String msgCode;
	public String content;
	
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
}

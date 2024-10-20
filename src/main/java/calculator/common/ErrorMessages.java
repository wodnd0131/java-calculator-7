package calculator.common;

public enum ErrorMessages {
	INVALID_CUSTOM_SEPARATOR("커스텀 구분자 지정이 올바르지 않습니다"),
	SEPARATOR_NOT_ALLOWED("허용되지 않은 구분자입니다"),
	;

	private final String message;

	ErrorMessages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}

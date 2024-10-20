package calculator.common;

public enum ErrorMessages {
	INVALID_CUSTOM_SEPARATOR("커스텀 구분자 지정이 올바르지 않습니다"),
	SEPARATOR_NOT_ALLOWED("허용되지 않은 구분자입니다"),
	CUSTOM_SEPARATOR_PREFIX("커스텀 구분자는 '//'로 시작해야 합니다"),
	CUSTOM_SEPARATOR_LENGTH("커스텀 구분자는 단일 문자여야 합니다"),
	CUSTOM_SEPARATOR_NUMERIC("커스텀 구분자에 숫자가 포함될 수 없습니다"),
	INVALID_INPUT("입력값이 올바르지 않습니다");;

	private final String message;

	ErrorMessages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}

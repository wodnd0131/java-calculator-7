package calculator.util;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import calculator.common.ErrorMessages;
import calculator.common.LoggerFactory;

public class Parser {
	private static final Logger logger = LoggerFactory.getLogger(Parser.class);
	private static final String DEFAULT_SEPARATOR = ",:";
	private static final String CUSTOM_SEPARATOR_PREFIX = "//";
	private static final String CUSTOM_SEPARATOR_SUFFIX = "\\\\n";
	private static final String NUMBER_REGEX = "\\d+";

	public List<Integer> parseInput(String input) {
		String separator = getSeparator(input);
		String[] items = getItems(input, separator);
		return separateItems(items);
	}

	private String getSeparator(String input) {
		String[] parts = input.split(CUSTOM_SEPARATOR_SUFFIX);
		return parts.length > 1
			? getCustomSeparator(parts[0])
			: DEFAULT_SEPARATOR;
	}

	private String getCustomSeparator(String part) {
		if (!part.startsWith(CUSTOM_SEPARATOR_PREFIX)) {
			throwInvalidCustomSeparatorException(ErrorMessages.CUSTOM_SEPARATOR_PREFIX);
		}
		if (part.length() != CUSTOM_SEPARATOR_PREFIX.length() + 1) {
			throwInvalidCustomSeparatorException(ErrorMessages.CUSTOM_SEPARATOR_LENGTH);
		}
		char separator = part.charAt(CUSTOM_SEPARATOR_PREFIX.length());
		if (Character.isDigit(separator)) {
			throwInvalidCustomSeparatorException(ErrorMessages.CUSTOM_SEPARATOR_NUMERIC);
		}
		return createRegexPattern(separator);
	}

	private void throwInvalidCustomSeparatorException(ErrorMessages errorMessage) {
		logger.log(Level.SEVERE, errorMessage.getMessage());
		throw new IllegalArgumentException(errorMessage.getMessage());
	}

	private String createRegexPattern(char separator) {
		String customSeparator = Pattern.quote(String.valueOf(separator));
		checkNumberInSeparator(customSeparator);
		return "[" + customSeparator + DEFAULT_SEPARATOR + "]";
	}

	private void checkNumberInSeparator(String customSeparator) {
		if (customSeparator.matches(NUMBER_REGEX)) {
			logger.log(Level.SEVERE, ErrorMessages.INVALID_CUSTOM_SEPARATOR.getMessage());
			throw new IllegalArgumentException(customSeparator);
		}
	}

	private String[] getItems(String input, String separator) {
		String[] parts = input.split(CUSTOM_SEPARATOR_SUFFIX);
		String content = parts.length > 1 ? parts[1] : input;
		return content.split(separator);
	}

	private List<Integer> separateItems(String[] items) {
		return Arrays.stream(items)
			.map(String::trim)
			.filter(item -> !item.isEmpty())
			.map(this::parseItem)
			.collect(Collectors.toList());
	}

	private Integer parseItem(String item) {
		if (item.matches(NUMBER_REGEX)) {
			return Integer.parseInt(item);
		} else {
			logger.log(Level.SEVERE, ErrorMessages.SEPARATOR_NOT_ALLOWED.getMessage());
			throw new IllegalArgumentException(item);
		}
	}
}

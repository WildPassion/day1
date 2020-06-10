package epam.javatr.dedik.day1.service;

import epam.javatr.dedik.day1.service.exception.ConvertException;
import epam.javatr.dedik.day1.service.validation.NumberValidator;
import epam.javatr.dedik.day1.service.validation.TimeValidator;

import java.time.Month;

public class StringConverter {
    private NumberValidator numberValidator = new NumberValidator();
    private TimeValidator timeValidator = new TimeValidator();

    public int toInteger(String number) {
        if (numberValidator.isInteger(number)) {
            return Integer.parseInt(number);
        } else {
            throw new ConvertException("Received value is not integer number.");
        }
    }

    public double toDouble(String number) {
        if (numberValidator.isDouble(number)) {
            return Double.parseDouble(number);
        } else {
            throw new ConvertException("Received value is not double number.");
        }
    }

    public Month toMonth(String month) {
        Month result;
        if (timeValidator.isValidMonth(month)) {
            if (numberValidator.isInteger(month)) {
                result = Month.values()[Integer.parseInt(month) - 1];
            } else {
                result = Month.valueOf(month.toUpperCase());
            }
        } else {
            throw new ConvertException("Received value is not a month.");
        }
        return result;
    }

    public int toYear(String year) {
        if (timeValidator.isValidYear(year)) {
            return Integer.parseInt(year);
        } else {
            throw new ConvertException("Received value is not valid year.");
        }
    }

    public int[] toArray(String numbers) {
        int[] array = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            if (numberValidator.isInteger(String.valueOf(numbers.charAt(i)))) {
                array[i] = Integer.parseInt(String.valueOf(numbers.charAt(i)));
            }
        }
        return array;
    }
}
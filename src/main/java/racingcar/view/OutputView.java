package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {
    private static final String DELIMITER_COLON = " : ";
    private static final String EACH_POSITION_SYMBOL = "-";
    private static final String DELIMITER_COMMA = ", ";
    private static final String WINNER_INFO_MESSAGE = "최종 우승자: ";

    public static void printWinners(List<Car> winners) {
        System.out.print(WINNER_INFO_MESSAGE);
        String printWinner = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER_COMMA));
        System.out.println(printWinner);
    }

    public static void printCars(Cars cars) {
        cars.getValue().stream()
                .forEach(car -> printCarPosition(car));
        System.out.println();
    }

    public static void printCarPosition(Car car) {
        System.out.println(car.getName() + DELIMITER_COLON + convertToPositionSymbols(car.getPosition()));
    }

    private static String convertToPositionSymbols(int position) {
        return Stream.generate(() -> EACH_POSITION_SYMBOL)
                .limit(position)
                .collect(Collectors.joining());
    }
}

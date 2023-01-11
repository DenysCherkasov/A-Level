package com.cherkasov.service;


import com.cherkasov.model.*;
import com.cherkasov.repository.CarArrayRepository;
import com.cherkasov.util.RandomGenerator;
import com.cherkasov.exceptions.UserInputException;
import lombok.SneakyThrows;
import org.apache.commons.lang3.EnumUtils;

import javax.sql.rowset.Predicate;
import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CarService {
    private final CarArrayRepository carArrayRepository;
    private final Random random = new Random();
    private final RandomGenerator randomGenerator = new RandomGenerator();

    private static CarService instance;

    private CarService(final CarArrayRepository carArrayRepository) {
        this.carArrayRepository = carArrayRepository;
    }

    public static CarService getInstance() {
        if (instance == null) {
            instance = new CarService(CarArrayRepository.getInstance());
        }
        return instance;
    }

    public static CarService getInstance(final CarArrayRepository repository) {
        if (instance == null) {
            instance = new CarService(repository);
        }
        return instance;
    }


    public Car create(Type type) {
        Engine engine = new Engine(getRandomString());
        Car car;
        if (type != Type.PASSENGERCAR && type != Type.TRUCK) {
            type = getRandomType();
        }
        if (type == Type.PASSENGERCAR) {
            car = new PassengerCar(getRandomString(),
                    engine, getRandomColor(),
                    randomGenerator.getRandomNumber());
        } else {
            car = new Truck(getRandomString(),
                    engine, getRandomColor(),
                    randomGenerator.getRandomNumber());
        }
        carArrayRepository.save(car);
        return car;
    }

    // tested //
    public void createWithCount(final int count) {
        for (int i = 0; i < count; i++) {
            create(getRandomType());
        }
    }

    // tested //
    public int createWithRandomCount(final RandomGenerator randomGenerator) {
        int count = randomGenerator.getRandomNumber();
        if (randomGenerator == null || count <= 0 || count > 10) {
            return -1;
        } else {
            for (int i = 0; i < count; i++) {
                print(create(getRandomType()));
            }
        }
        return count;
    }

    public boolean carEquals(final Car firstCar, final Car secondCar) {
        if (firstCar == null || secondCar == null ||
                firstCar.getType() != secondCar.getType() ||
                firstCar.hashCode() != secondCar.hashCode()) {
            return false;
        }
        return firstCar.equals(secondCar);
    }

    //tested//
    public void insert(int index, final Car car) {
        if (index < 0 || car == null) {
            return;
        }
        carArrayRepository.insert(index, car);
    }

    //tested//
    public static void check(Car car) {
        if (car.getCount() >= 1 && (car.getEngine().getPower() > 200)) {
            System.out.println("The car is ready for sale");
        } else if (car.getCount() < 1 && (car.getEngine().getPower() > 200)) {
            System.out.println("The count of the car = 0");
        } else if (car.getCount() >= 1 && (car.getEngine().getPower() <= 200)) {

System.out.println("The engine power of the car is less than 200");
        } else {
            System.out.println("The count of the car = 0 and the engine power " +
                    "of the car is less than 200");
        }
    }

    // tested //
    public void print(Car car) {
        System.out.println(car.toString());
    }

    // tested //
    public void printAll() {
        final Car[] all = carArrayRepository.getAll();
        System.out.println(Arrays.toString(all));
    }

    //tested//
    public Car[] getAll() {
        return carArrayRepository.getAll();
    }

    //tested//
    public Optional <Car> find(final String id) {
        if (id == null || id.isEmpty()) {
            System.out.println("Invalid ID, the car is not found!");
            return null;
        }
        return carArrayRepository.getById(id);
    }

    //tested//
    public void delete(final String id) {
        if (id == null || id.isEmpty()) {
            System.out.println("Invalid ID, the car is not found!");
            return;
        }
        carArrayRepository.delete(id);
    }

    private Color getRandomColor() {
        final Color[] values = Color.values();
        final int randomIndex = random.nextInt(values.length);
        return values[randomIndex];
    }

    private Type getRandomType() {
        final Type[] values = Type.values();
        final int randomIndex = random.nextInt(values.length);
        return values[randomIndex];
    }


    public void changeRandomColor(final String id) {
        find(id)
                .ifPresent (car -> findAndChangeRandomColor(car));
    }

    private void findAndChangeRandomColor(final Car car) {
        final Color color = car.getColor();
        Color randomColor;
        do {
            randomColor = getRandomColor();
        } while (randomColor == color);
        carArrayRepository.updateColor(car.getId(), randomColor);
    }

    //tested//
    public String getRandomString() {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        int length = random.nextInt(5, 10);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public void printManufacturerAndCount(final Car car) {
        Optional.ofNullable(car).ifPresent(ManufacturerAndCount -> {
            System.out.println("Manufacturer: " + car.getManufacturer() +
                    ", Count: " + car.getCount());
        });
    }

    public void printColor(final Car car) {
        Car newCar = Optional.ofNullable(car).orElse(new PassengerCar(getRandomString(),
                new Engine(getRandomString()), getRandomColor(),
                randomGenerator.getRandomNumber()));
        System.out.println("Color: " + newCar.getColor());
    }

    public void printEngineInfo(final Car car) {
        Car newCar = Optional.ofNullable(car)
                .orElseGet(() -> create(Type.PASSENGERCAR));
        System.out.println("Engine: " + newCar.getEngine());
    }

    public void printInfo(final Car car) {
        Optional.ofNullable(car)
                .ifPresentOrElse(
                        newCar -> {
                            System.out.println("Car: " + newCar);
                        },
                        () -> {
                            Car newCar = create(Type.PASSENGERCAR);
                            System.out.println("New car: " + newCar);
                        });
    }

    public void checkCount(final Car car) {
        Optional.ofNullable(car).filter(count -> car.getCount() > 10)
                .orElseThrow(UserInputException::new);
        System.out.println("Manufacturer: " +
                car.getManufacturer() + ", Count: " + car.getCount());

    }

    public void checkCount2(final Car car) {
        Optional<Car> carOptional = Optional.ofNullable(car);
        Optional.ofNullable(car)
                .ifPresent(type -> {
                    carOptional.filter(count -> {
                                final boolean b = car.getCount() > 10;
                                if (b) {
                                    System.out.println("Manufacturer: " +
                                            count.getManufacturer() +
                                            ", Count: " + count.getCount());
                                }
                                return b;
                            })
                            .orElseThrow(UserInputException::new);
                });
    }

    public Map<String, Integer> listToMapManufacturerCount(List<Car> list) {
        Map<String, Integer> mapCars = list.stream()
                .collect(Collectors.toMap(Car::getManufacturer, Car::getCount, (item, identicalItem) -> item));
        return mapCars;
    }

    public Map<Engine, List<Car>> listToMapPowerEngineListCar(List<Car> list) {
        final Map<Engine, List<Car>> map = new HashMap<>();
        for (Car car : list) {
            map.computeIfAbsent(car.getEngine(), key -> {
                final List<Car> engineCars = new ArrayList<>();
                engineCars.add(car);
                return engineCars;
            });
            map.computeIfPresent(car.getEngine(), (key, value) -> {
                value.add(car);
                return value;
            });
        }
        return map;
    }


    public void findManafacturerByPrice(List<Car> list, int price) {
        list.stream()
                .filter(car -> car.getPrice() > price)
                .forEach(car -> System.out.println("Manufacturer: " + car.getManufacturer()));
    }

    public int countSum(List<Car> list) {
        int sum = list.stream()
                .map(Car::getCount)
                .reduce(0, (left, right) -> left + right);
        return sum;
    }

    public LinkedHashMap<String, Type> mapToMap(List<Car> list) {
        LinkedHashMap<String, Type> map = list.stream()
                .sorted(Comparator.comparing(Car::getManufacturer))
                .distinct()
                .peek(car -> System.out.println(car))
                .collect(
                        LinkedHashMap::new,
                        (myMap, car) -> myMap.put(car.getId(), car.getType()),
                        (list1, list2) -> list1.putAll(list2));
        return map;
    }


    public void statistic(List<Car> list) {
        IntSummaryStatistics stats = list.stream()
                .mapToInt(Car::getPrice)
                .summaryStatistics();
        System.out.println(stats);
    }

    public boolean priceCheck(List<Car> list, int price) {
        final boolean result = list.stream()
                .mapToInt(Car::getPrice)
                .allMatch(val -> val > price);
        return result;
    }

    public Map<Color, Integer> innerList(List<List<Car>> list, int price) {
        return list.stream()
                .flatMap(Collection::stream)
                .sorted(Comparator.comparing(Car::getColor))
                .peek((car) -> {
                    System.out.println(car);
                })
                .collect(Collectors.toMap(Car::getColor, Car::getCount, (item, identicalItem) -> item));
    }

    public Car mapToObject(Map map) {
        Function<Map<String, String>, Car> mapper = map1 -> {
            String typeString = (String) map.getOrDefault("type", "PASSENGERCAR");
            Type type = EnumUtils.getEnum(Type.class, typeString);
            if (type == Type.PASSENGERCAR) {
                return createPassengerCar(map1);
            } else {
                return createTruck(map1);
            }
        };
        return mapper.apply(map);
    }

    private static Car createPassengerCar(final Map<String, String> map) {
        PassengerCar passengerCar = (PassengerCar) createCar(map, Type.PASSENGERCAR);
        final String stringPassengerCount = map.getOrDefault("passengerCount", "1");
        int passengerCount = Integer.parseInt(stringPassengerCount);
        passengerCar.setPassengerCount(passengerCount);
        return passengerCar;
    }

    private static Car createTruck(final Map<String, String> map) {
        Truck truck = (Truck) createCar(map, Type.TRUCK);
        final String stringLoadCapacity = map.getOrDefault("loadCopacity", "10");
        int loadCapacity = Integer.parseInt(stringLoadCapacity);
        truck.setLoadCopacity(loadCapacity);
        return truck;
    }

    private static Car createCar(final Map<String, String> map, Type type) {
        final Car car;
        if (type == Type.PASSENGERCAR) {
            car = new PassengerCar();
        } else {
            car = new Truck();
        }
        car.setType(type);
        final String StringCount = map.getOrDefault("count", "10");
        int count = Integer.parseInt(StringCount);
        car.setCount(count);
        final String StringPrice = map.getOrDefault("price", "1000");
        int price = Integer.parseInt(StringPrice);
        car.setPrice(price);
        final String StringColor = map.getOrDefault("color", "BLACK");
        Color color = Color.valueOf(StringColor);
        car.setColor(color);
        final String StringPower = map.getOrDefault("power", "777");
        int power = Integer.parseInt(StringPower);
        final String engineType = map.getOrDefault("engineType", "diesel");
        car.setEngine(new Engine(engineType, power));
        final String manufacturer = map.getOrDefault("manufacturer", instance.getRandomString());
        car.setManufacturer(manufacturer);
        final String id = map.getOrDefault("id", UUID.randomUUID().toString());
        car.setId(id);
        return car;
    }

    public Car fileToCar(String fileWay) {
        Map<String, String> carFields = fileToMap(fileWay);
        return mapToObject(carFields);
    }

    private Map<String, String> fileToMap(final String fileWay) {
        InputStreamReader inputStreamReader = createInputStreamReader(fileWay);
        if (fileWay.endsWith(".json")) {
            return fileToMap(inputStreamReader, "\"(.*)\".*\"(.*)\".*");
        }
        if (fileWay.endsWith(".xml")) {
            return fileToMap(inputStreamReader, "<(.*?)>(.*)<");
        } else {
            throw new UserInputException("File not found");
        }
    }

    private InputStreamReader createInputStreamReader(final String fileWay) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream input = loader.getResourceAsStream(fileWay);
        InputStreamReader inputStreamReader = new InputStreamReader(input);
        return inputStreamReader;
    }

    // FIX ME
    private Map<String, String> fileToMap(final InputStreamReader inputStreamReader, final String regex) {
        Map<String, String> map = new HashMap<>();
        String s;
        try {
            BufferedReader reader = new BufferedReader(inputStreamReader);
            while ((s = reader.readLine()) != null) {
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(s);
                if (matcher.find()) {
                    map.put(matcher.group(1), matcher.group(2));
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return map;
    }


}


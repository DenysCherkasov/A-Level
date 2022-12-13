package com.cherkasov;


import com.cherkasov.model.Engine;
import com.cherkasov.repository.CarArrayRepository;
import com.cherkasov.service.CarService;

import java.util.Optional;

public class MainOptional {
    private static final CarService carService = new CarService(new CarArrayRepository());

    public static void main(String[] args) {

/*
        final Optional<Engine> engineEmptyOptional = carService.createEngine("werweftg");
        final Optional<Engine> enginePresentOptional = carService.createEngine("oil");
//        myGetAndIsPresent(engineEmptyOptional);
//        myGetAndIsPresent(enginePresentOptional);
//        myIfPresent(engineEmptyOptional);
//        myIfPresent(enginePresentOptional);
//        myOrElse(engineEmptyOptional);
//        myOrElse(enginePresentOptional);
//        try {
//            myOrElseThrow(engineEmptyOptional);
//        } catch (IllegalAccessError e) {
//            e.printStackTrace();
//        }
//        myOrElseThrow(enginePresentOptional);
//        myOrElseGet(engineEmptyOptional);
//        myOrElseGet(enginePresentOptional);
//        myMap(engineEmptyOptional);
//        myMap(enginePresentOptional);
//        myFilter(engineEmptyOptional);
//        myFilter(enginePresentOptional);
//        enginePresentOptional.ifPresent(engine -> ((OilEngine) engine).setPower(0));
//        myFilter(enginePresentOptional);
//        myIfPresentOrElse(engineEmptyOptional);
//        myIfPresentOrElse(enginePresentOptional);
//        myOr(engineEmptyOptional);
//        myOr(enginePresentOptional);
        inputCanBeNull(null);
        inputCanBeNull("test");
    }
    private static void myGetAndIsPresent(final Optional<Engine> engineOptional) {
        if (engineOptional.isPresent()) {
            final Engine engine = engineOptional.get();
            System.out.println("Engine " + engine);
        } else {
            System.out.println("Optional is empty");
        }
    }
    private static void myIfPresent(final Optional<Engine> engineOptional) {
        engineOptional.ifPresent(engine -> {
            System.out.println("Engine " + engine);
        });
    }
    private static void myOrElse(final Optional<Engine> engineOptional) {
        final Engine engine = engineOptional.orElse(new ElectricEngine());
        System.out.println("Engine " + engine);
    }
    private static void myOrElseThrow(final Optional<Engine> engineOptional) {
        final Engine engine = engineOptional.orElseThrow(IllegalAccessError::new);
        System.out.println("Engine " + engine);
    }
    private static void myOrElseGet(final Optional<Engine> engineOptional) {
        final Engine engine = engineOptional.orElseGet(() -> {
            return carService.createDefaultEngine();
        });
        System.out.println("Engine " + engine);
    }
    private static void myMap(final Optional<Engine> engineOptional) {
        engineOptional
                .map(e -> {
                    System.out.println("Change type from Engine to String");
                    return e.getType();
                })
                .ifPresent(type -> {
                    System.out.println("Engine type " + type);
                });
    }
    private static void myFilter(final Optional<Engine> engineOptional) {
        engineOptional
                .filter(e -> {
                    final boolean b = e.calculatePower() != 0;
                    System.out.println("Check power " + b);
                    return b;
                })
                .ifPresent(engine -> {
                    System.out.println("Engine type " + engine);
                });
    }
    private static void myIfPresentOrElse(final Optional<Engine> engineOptional) {
        engineOptional.ifPresentOrElse(
                engine -> {
                    System.out.println("Engine " + engine);
                },
                () -> {
                    final Engine defaultEngine = carService.createDefaultEngine();
                    System.out.println("Default engine " + defaultEngine);
                }
        );
    }
    private static void myOr(final Optional<Engine> engineOptional) {
        final Optional<Engine> engineOptionalNew = engineOptional
                .or(() -> carService.createEngine("oil"));
        myIfPresent(engineOptionalNew);
    }
    private static void inputCanBeNull(final String one) {
        if (one != null) {
            final String s = one.toUpperCase();
            System.out.println(s);
        }
        Optional.ofNullable(one)
                .map(s -> {
                    return s.toUpperCase();
                })
                .ifPresent(s -> {
                    System.out.println(s);
                });
    }
 */
    }
}

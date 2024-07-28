package DesignPatterns.Creational.Factory;

import java.util.List;
import java.util.function.Function;

public class FunctionalFactory {
    static Function<AttackingEntity, String> makeAttack(AttackingEntities type) {
        return switch (type) {
            case Human -> (AttackingEntity gob ) -> "human attacks " + gob;
            case Goblin -> (AttackingEntity gob ) -> "goblin attacks " + gob;
        };
    }

    public static void main(String[] args) {
        var gobAttack = FunctionalFactory.makeAttack(AttackingEntities.Goblin);
        var humanAttack =FunctionalFactory.makeAttack(AttackingEntities.Human);
        List.of(gobAttack.apply(new Human()),
        humanAttack.apply(new Goblin())).forEach(System.out::println);
    }
}

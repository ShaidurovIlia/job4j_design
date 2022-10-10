package ru.job4j.ocp;

public class Plants {

    static class Flowers {
        static void colors() {
        }
    }

    static class Rose extends Flowers {
        static void colors() {
        }

        static void smell() {
        }
    }

    static class Peonies extends Flowers {
        static void smell() {
        }

        static void price() {
        }
    }
}
/**
 * Расширение класса за счет наследования,
 * растет иерархия наследования.
 */

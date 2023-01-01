package ru.job4j.encapsulation.enums;

public enum Status {
    ACCEPTED("Принят") {
        private String message = "Автомобиль принят на СТО";

        public String getMessage() {
            return message;
        }

    },
    WAITING("Ожидание") {
        private String message = "Автомобиль ожидает запчасти";

        @Override
        public String getMessage() {
            return message;
        }
    },
    FINISHED("Работы завершены") {
        private String message = "Все работы завершены";

        @Override
        public String getMessage() {
            return message;
        }
    };

    private String info;

    Status(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public abstract String getMessage();

    /*ACCEPTED("Принят"),
    IN_WORK("В работе"),
    WAITING("Ожидание"),
    FINISHED("Работы завершены");

    private String info;

    Status(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }*/
}
/*перечисление - это список неизменяемых готовых объектов, которыми можно пользоваться.
* ACCEPTED("Принят") {
        private String message = "Автомобиль принят на СТО";

        @Override
        public String getMessage() {
            return message;
        }

    }
* */
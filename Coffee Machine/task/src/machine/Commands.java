package machine;

public enum Commands {
    BUY("buy"),
    FILL("fill"),
    TAKE("take"),
    REMAINING("remaining"),
    EXIT("exit");

        private final String key;

        Commands(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }
    }


package mock_practice;

class UrlShortener {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int BASE = 62;

    private Map<String, String> shortToLong = new HashMap<>();
    private Map<String, String> longToShort = new HashMap<>();
    private long counter = 1;

    // Encode long URL to short URL
    public String encode(String longUrl) {
        if (longToShort.containsKey(longUrl)) {
            return "http://short.ly/" + longToShort.get(longUrl);
        }

        String shortCode = base62Encode(counter++);
        shortToLong.put(shortCode, longUrl);
        longToShort.put(longUrl, shortCode);

        return "http://short.ly/" + shortCode;
    }

    // Decode short URL to long URL
    public String decode(String shortUrl) {
        String code = shortUrl.replace("http://short.ly/", "");
        return shortToLong.get(code);
    }

    // Base62 encoding
    private String base62Encode(long num) {
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            sb.append(ALPHABET.charAt((int)(num % BASE)));
            num /= BASE;
        }

        return sb.reverse().toString();
    }
}
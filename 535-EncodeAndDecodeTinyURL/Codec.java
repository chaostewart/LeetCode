public class Codec {
    Map<String, String> longIsKey = new HashMap<>();  // this hashmap is for checking if a longUrl has been encoded before
    Map<String, String> tinyIsKey = new HashMap<>();  // map <tinyUrl, longUrl>
    static String BASE_HOST = "https://leetcode.com/";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (longIsKey.containsKey(longUrl)) return BASE_HOST + longIsKey.get(longUrl);
        String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";  // 26 + 26 + 10
        String tiny = null;
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append(charSet.charAt((int) Math.random() * charSet.length()));   // random() generate a double (0, 1)
            }
            tiny = sb.toString();
        } while (tinyIsKey.containsKey(tiny));   // keep generating new tiny url if collision happens
        longIsKey.put(longUrl, tiny);
        tinyIsKey.put(tiny, longUrl);
        return BASE_HOST + tiny;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return tinyIsKey.get(shortUrl.replace(BASE_HOST, ""));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
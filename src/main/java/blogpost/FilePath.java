package main.java.blogpost;

public enum FilePath {
    JSONFILE("output/resources/userblogPosts.json");

    public final String value;

    private FilePath(String value) {
        this.value = value;
    }
}

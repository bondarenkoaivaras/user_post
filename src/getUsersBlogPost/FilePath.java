package getUsersBlogPost;

public enum FilePath {
    JSONFILE("src/getUsersBlogPost/userblogPosts.json");

    public final String value;

    private FilePath(String value) {
        this.value = value;
    }
}

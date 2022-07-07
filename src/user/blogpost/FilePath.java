package user.blogpost;

public enum FilePath {
    JSONFILE("src/user/blogpost/userblogPosts.json");

    public final String value;

    private FilePath(String value) {
        this.value = value;
    }
}

package javaDemo.stream;

import java.util.List;

/**
 * 文刊类
 *
 * @author chen
 * @description
 */
@SuppressWarnings("all")
public class Article {
    private final String title;
    private final String author;
    private final List<String> tags;

    public Article(String title, String author, List<String> tags) {
        this.title = title;
        this.author = author;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public List<String> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "文章标题：" + this.getTitle() + " 作者：" + this.getAuthor() + " 标签：" + this.getTags();
    }
}

package stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * main
 */
@SuppressWarnings("all")
public class Main {

    public static List<Article> articles = new ArrayList<Article>();

    Main() {
        articles.add(new Article("文章1", "cheng", Arrays.asList("Buenos Aires", "Córdoba", "La Plata")));
        articles.add(new Article("文章2", "hu", Arrays.asList("C#", "Java", "PHP")));
        articles.add(new Article("文章3", "hucheng", Arrays.asList("JavaSE", "JavaEE", "Java")));
    }

    public static void main(String[] arg) {
        //输出一次匹配
        Main mains = new Main();
        Optional<Article> article = mains.getFirstJavaArticleNew();
        System.out.println(article.toString());

        //输出所有匹配
        List<Article> allJavaArticles = mains.getAllJavaArticlesNew();

        //stream 输出list
        allJavaArticles.stream().forEach(
                javaArticles -> {
                    System.out.println(javaArticles.toString());
                }
        );

        //获取所有子集tags输出
        Set<String> tags = mains.getDistinctTags();
        tags.stream().forEach(
                s -> {
                    System.out.println(s);
                }
        );
    }


    /**
     * 传统Java获取匹配输出
     *
     * @return
     */
    public Article getFirstJavaArticle() {
        for (Article article : articles) {
            if (article.getTags().contains("Java")) {
                return article;
            }
        }
        return null;
    }

    /**
     * Java8流式操作匹配输出
     *
     * @return
     */
    public Optional<Article> getFirstJavaArticleNew() {
        return articles.stream()
                .filter(article -> article.getTags().contains("Java"))
                .findFirst();
    }

    /**
     * 传统输出所有的匹配
     *
     * @return
     */
    public List<Article> getAllJavaArticles() {
        List<Article> result = new ArrayList<>();
        for (Article article : articles) {
            if (article.getTags().contains("Java")) {
                result.add(article);
            }
        }
        return result;
    }

    /**
     * stream 输出全部匹配
     *
     * @return
     */
    public List<Article> getAllJavaArticlesNew() {
        return articles.stream()
                .filter(article -> article.getTags().contains("Java"))
                .collect(Collectors.toList());
    }

    /**
     * 获取一个包含子集的set集合
     *
     * @return
     */
    public Set<String> getDistinctTags() {
        return articles.stream()
                .flatMap(article -> article.getTags().stream())
                .collect(Collectors.toSet());
    }

}

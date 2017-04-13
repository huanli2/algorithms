
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Created by lih on 2017/3/30.
 *
 *  * source
 *     https://juejin.im/post/58d1377561ff4b006ca9ba49?utm_source=gold_browser_extension
 *
 * Runnable和Callable：表示要执行的异步任务
 * Executor和ExecutorService：表示执行服务
 * Future：表示异步任务的结果
 */
public class InvokeAllDemo {
    static class UrlTitleParser implements Callable<String> {
        private String url;

        public UrlTitleParser(String url) {
            this.url = url;
        }

        public String call() throws Exception {
            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.select("head title");

            if (elements.size() > 0) {
                return elements.get(0).text();
            }

            return null;
        }

        public static void main(String args[]) {
            ExecutorService executor = Executors.newFixedThreadPool(10);

            InvokeAllTest(executor);
            executor.shutdown();
        }
    }

    private static void InvokeAllTest(ExecutorService executor) {
        String url1 = "http://www.cnblogs.com/swiftma/p/5396551.html";
        String url2= "http://www.cnblogs.com/swiftma/p/5399315.html";
        String url3 = "https://juejin.im/post/58dc3c9961ff4b006b0149ee?utm_source=gold_browser_extension";

        Collection<UrlTitleParser> tasks = Arrays.asList(new UrlTitleParser[] {
                new UrlTitleParser(url1), new UrlTitleParser(url2), new UrlTitleParser(url3)
        });

        try {
            List<Future<String> > results = executor.invokeAll(tasks, 10, TimeUnit.SECONDS);

            for (Future<String> result : results) {

                try {
                    System.out.println(result.get());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

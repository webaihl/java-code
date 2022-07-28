package org.example.design.behavioral.chain.ext;


// 1---2---3--my---3---2---1
public class MainTest {

    public static void main(String[] args) {
        FilterChain chain = new FilterChain();

        //web.xml =- filter
        Filter filter = new HttpFilter();
        Filter characterFilter = new CharacterFilter();
        Filter encodingFilter = new EncodingFilter();
        chain.addFilter(filter);
        chain.addFilter(characterFilter);
        chain.addFilter(encodingFilter);


        chain.setTarget(new My());

        //filter如何链式执行。

        chain.doFilter(new Request("hello world"),
                new Response("adhkjasdhak"),chain);


    }
}

package org.example.jvm;

import java.util.List;

/**
 * @author web
 * @date 2022年08月24日
 */
public class GenericArgument {

//'accept(List<String>)' clashes with 'accept(List<Integer>)';
// both methods have same erasure
//  public void accept(List<String> names){}
    public void accept(List<Integer> nums){}
}

package org.example.functional.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author web
 * @date 2022年04月27日
 */
@Data
@AllArgsConstructor
public class AppInfo {

    private String name;
    private String category;
    private Integer count;
}

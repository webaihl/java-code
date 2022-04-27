package org.example.functional.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author web
 * @date 2022年04月27日
 */

@Data
@AllArgsConstructor
public class SearchResult {
    String name;
    List<AppInfo> appInfos;
}

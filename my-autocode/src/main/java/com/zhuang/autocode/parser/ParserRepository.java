package com.zhuang.autocode.parser;

import com.zhuang.autocode.parser.impl.DateTimeParser;
import com.zhuang.autocode.parser.impl.SequenceParser;

import java.util.HashMap;
import java.util.Map;

public class ParserRepository {

    private static ParserRepository instance;
    private final Map<String, Parser> mapParsers;

    public static synchronized ParserRepository getInstance() {
        if (instance == null) {
            instance = create();
        }
        return instance;
    }

    private static ParserRepository create() {
        ParserRepository result = new ParserRepository();
        result.addParser(new DateTimeParser());
        result.addParser(new SequenceParser());
        return result;
    }

    public ParserRepository() {
        mapParsers = new HashMap<>();
    }

    public Parser getParser(String name) {
        return mapParsers.getOrDefault(name, null);
    }

    public void addParser(Parser parser) {
        mapParsers.put(parser.getName(), parser);
    }
}

package com.zhuang.autocode.parser;

import java.util.HashMap;
import java.util.Map;

public class ParserRepository {

	private static ParserRepository instance;

	private Map<String, Parser> mapParsers;

	public static synchronized ParserRepository getInstance() {

		if (instance == null) {
			instance = Create();
		}

		return instance;
	}

    private static ParserRepository Create()
    {
        ParserRepository result = new ParserRepository();

        result.AddParser(new DateTimeParser());
        result.AddParser(new SequenceParser());
        
        return result;
    }
	
	public ParserRepository() {
		mapParsers = new HashMap<String, Parser>();
	}

	public Parser GetParser(String name) {
		if (mapParsers.containsKey(name)) {
			return mapParsers.get(name);
		} else {
			return null;
		}
	}

	public void AddParser(Parser parser) {
		mapParsers.put(parser.getName(), parser);
	}
}

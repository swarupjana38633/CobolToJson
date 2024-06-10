package net.sf.cobolToJson.impl.jsonSchema;

import java.util.ArrayList;
import java.util.List;

public class JsonItem {
	public final  JsonItem parent;
	private final JsonType jsonType;
	private final String name;
	private final Integer postion;
	private final Integer storageLength;
	private final Integer displayLength;
	private final List<JsonItem> children;
	
	public JsonItem(JsonItem parent, JsonType jsonType) {
		this(parent, jsonType, null, 0, 0, 0);
	}
	public JsonItem(JsonItem parent, JsonType jsonType, String name) {
		this(parent, jsonType, name, 0, 0, 0);
	}
	public JsonItem(JsonItem parent, JsonType jsonType, String name, int postion, int storageLength, int displayLength) {
		super();
		this.parent = parent;
		this.jsonType = jsonType;
		this.name = name;
		this.postion = postion;
		this.storageLength = storageLength;
		this.displayLength = displayLength;
		this.children = jsonType.hasChildren ? new ArrayList<>() : null;
		if (parent != null) {
			if (parent.children == null) {
				System.err.println("No children: " + parent.name + " " + name);
			}
			parent.children.add(this);
		}
	}

	public String getName() {
		return name;
	}
	public JsonType getJsonType() {
		return jsonType;
	}
	public Integer getPosition() {
		return postion;
	}
	public Integer getStorageLength() {
		return storageLength;
	}
	public Integer getDisplayLength() {
		return displayLength;
	}

	public List<JsonItem> getChildren() {
		return children;
	}

	public boolean add(JsonItem e) {
		return children.add(e);
	}
	
	
}

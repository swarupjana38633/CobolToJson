package net.sf.cobolToJson.impl.jsonWriter;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import net.sf.JRecord.schema.jaxb.IItem;
import net.sf.cobolToJson.impl.jsonSchema.JsonItem;
import net.sf.cobolToJson.impl.jsonSchema.JsonType;

public class JsonSchemaCreator implements IJsonWriter {
	
	private JsonItem current, schemaItem;
	@Override
	public void initWriter(boolean pretty) {

	}

	@Override
	public void writeStartArray(IItem item) throws IOException {
		current = new JsonItem(current, JsonType.ARRAY);
		setSchemaItem();
	}

	private void setSchemaItem() {
		if (schemaItem == null) {
			schemaItem = current;
		}
	}

	@Override
	public void writeArrayFieldStart(IItem item, String fieldName) throws IOException {
		if(item == null){
			current = new JsonItem(current, JsonType.ARRAY, fieldName);
		} else {
			current = new JsonItem(current, JsonType.ARRAY, fieldName, item.getPosition(), item.getStorageLength(), item.getDisplayLength());
		}
		setSchemaItem();
	}

	@Override
	public void writeEndArray() throws IOException {
		current = current.parent;
	}

//	@Override
//	public void writeStartObject() throws IOException {
//		current = new JsonItem(current, JsonType.OBJECT);
//		setSchemaItem();
//	}
	@Override
	public void writeStartObject() throws IOException {
		if (current != null && current.getJsonType() == JsonType.ARRAY) {
			List<JsonItem> children = current.getChildren();
			if (children != null && children.size() == 1 && children.get(0).getJsonType() == JsonType.OBJECT) {
				current = children.get(0);
			}
		}

		current = new JsonItem(current, JsonType.OBJECT);
		setSchemaItem();
	}

	@Override
	public void writeStartObject(IItem item, Object forValue) throws IOException {
		current = new JsonItem(current, JsonType.OBJECT, forValue.toString(), item.getPosition(), item.getStorageLength(), item.getDisplayLength());
	}

	@Override
	public void writeObjectFieldStart(IItem item, String fieldName) throws IOException {
		current = new JsonItem(current, JsonType.OBJECT, fieldName, item.getPosition(), item.getStorageLength(), item.getDisplayLength());
	}

	@Override
	public void writeEndObject() throws IOException {
		current = current.parent;
	}

	@Override
	public void writeString(IItem item, String text) throws IOException {
		new JsonItem(current, JsonType.STRING);
	}

	@Override
	public void writeNumber(IItem item, BigDecimal v) throws IOException {
		new JsonItem(current, getNumericType(item));
	}

	@Override
	public void writeStringField(IItem item, String fieldName, String value) throws IOException {
		new JsonItem(current, JsonType.STRING, fieldName, item.getPosition(), item.getStorageLength(), item.getDisplayLength());
	}

	@Override
	public void writeNumberField(IItem item, String fieldName, BigDecimal value) throws IOException {
		new JsonItem(current, getNumericType(item), fieldName, item.getPosition(), item.getStorageLength(), item.getDisplayLength());
	}
	

	private JsonType getNumericType(IItem item) {
		return item.getScale() > 0 ? JsonType.NUMBER : JsonType.INTEGER;
	}


	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub

	}

	public JsonItem getSchemaItem() {
		return schemaItem;
	}

}

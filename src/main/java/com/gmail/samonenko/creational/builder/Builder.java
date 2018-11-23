package com.gmail.samonenko.creational.builder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Motivation: to use when construction of object is significant.
 */

public class Builder {
    public static void main(String[] args) {
        CodeBuilder codeBuilder = new CodeBuilder("Person")
                .addField("name", "String")
                .addField("age", "int");
        System.out.println(codeBuilder);
    }
}

@Getter
@AllArgsConstructor
class Field {
    private String name;
    private String type;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class Code {
    private String className;
    private List<Field> fields = new ArrayList<>();
}

class CodeBuilder {

    private String accessModifier = "public";
    private Code code = new Code();

    public CodeBuilder(String className) {
        code.setClassName(className);
    }

    public CodeBuilder addField(String name, String type) {
        code.getFields().add(new Field(name, type));
        return this;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Field field : code.getFields())
            stringBuilder.append("  " + accessModifier + " " + field.getType() + " " + field.getName() + ";\n");
        return accessModifier + " class " + code.getClassName() + "\n" + "{\n" + stringBuilder + "}";
    }

}

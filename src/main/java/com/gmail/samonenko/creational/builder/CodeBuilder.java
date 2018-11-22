package com.gmail.samonenko.creational.builder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class Field {
    String type;
    String name;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class Code {
    String className;
    List<Field> fields = new ArrayList<>();
}

public class CodeBuilder {

    private String accessModifier = "public";
    private Code code = new Code();

    public CodeBuilder(String className) {
        code.className = className;
    }

    public CodeBuilder addField(String name, String type) {
        code.fields.add(new Field(name, type));
        return this;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Field field : code.getFields())
            stringBuilder.append("  " + field.getType() + " " + field.getName() + "\n");
        return accessModifier + " class " + code.className + "\n" + "{\n" + stringBuilder + "}";
    }

    public static void main(String[] args) {
        CodeBuilder codeBuilder = new CodeBuilder("Person")
                .addField("name", "String")
                .addField("age", "int");
        System.out.println(codeBuilder);
    }
}

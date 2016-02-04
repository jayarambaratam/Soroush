package org.jivesoftware.smackx.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.frakbot.glowpadbackport.BuildConfig;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.FormField.Type;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jivesoftware.smackx.xdata.packet.DataForm.Item;

public class ReportedData {
    private List<Column> columns;
    private List<Row> rows;
    private String title;

    public class Column {
        private final String label;
        private final Type type;
        private final String variable;

        public Column(String str, String str2, Type type) {
            this.label = str;
            this.variable = str2;
            this.type = type;
        }

        public String getLabel() {
            return this.label;
        }

        public Type getType() {
            return this.type;
        }

        public String getVariable() {
            return this.variable;
        }
    }

    public class Field {
        private List<String> values;
        private String variable;

        public Field(String str, List<String> list) {
            this.variable = str;
            this.values = list;
        }

        public List<String> getValues() {
            return Collections.unmodifiableList(this.values);
        }

        public String getVariable() {
            return this.variable;
        }
    }

    public class Row {
        private List<Field> fields;

        public Row(List<Field> list) {
            this.fields = new ArrayList();
            this.fields = list;
        }

        private List<Field> getFields() {
            return Collections.unmodifiableList(new ArrayList(this.fields));
        }

        public List<String> getValues(String str) {
            for (Field field : getFields()) {
                if (str.equalsIgnoreCase(field.getVariable())) {
                    return field.getValues();
                }
            }
            return null;
        }
    }

    public ReportedData() {
        this.columns = new ArrayList();
        this.rows = new ArrayList();
        this.title = BuildConfig.FLAVOR;
    }

    private ReportedData(DataForm dataForm) {
        this.columns = new ArrayList();
        this.rows = new ArrayList();
        this.title = BuildConfig.FLAVOR;
        for (FormField formField : dataForm.getReportedData().getFields()) {
            this.columns.add(new Column(formField.getLabel(), formField.getVariable(), formField.getType()));
        }
        for (Item item : dataForm.getItems()) {
            List arrayList = new ArrayList(this.columns.size());
            for (FormField formField2 : item.getFields()) {
                List arrayList2 = new ArrayList();
                for (String add : formField2.getValues()) {
                    arrayList2.add(add);
                }
                arrayList.add(new Field(formField2.getVariable(), arrayList2));
            }
            this.rows.add(new Row(arrayList));
        }
        this.title = dataForm.getTitle();
    }

    public static ReportedData getReportedDataFrom(Stanza stanza) {
        DataForm from = DataForm.from(stanza);
        return (from == null || from.getReportedData() == null) ? null : new ReportedData(from);
    }

    public void addColumn(Column column) {
        this.columns.add(column);
    }

    public void addRow(Row row) {
        this.rows.add(row);
    }

    public List<Column> getColumns() {
        return Collections.unmodifiableList(new ArrayList(this.columns));
    }

    public List<Row> getRows() {
        return Collections.unmodifiableList(new ArrayList(this.rows));
    }

    public String getTitle() {
        return this.title;
    }
}

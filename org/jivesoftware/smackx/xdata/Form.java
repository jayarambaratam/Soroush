package org.jivesoftware.smackx.xdata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import net.frakbot.glowpadbackport.BuildConfig;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.xdata.FormField.Type;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

public class Form {
    private DataForm dataForm;

    /* renamed from: org.jivesoftware.smackx.xdata.Form.1 */
    /* synthetic */ class C27851 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type;

        static {
            $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type = new int[Type.values().length];
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[Type.text_multi.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[Type.text_private.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[Type.text_single.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[Type.jid_single.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[Type.hidden.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[Type.jid_multi.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[Type.list_multi.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[Type.list_single.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    public Form(DataForm.Type type) {
        this.dataForm = new DataForm(type);
    }

    public Form(DataForm dataForm) {
        this.dataForm = dataForm;
    }

    public static Form getFormFrom(Stanza stanza) {
        DataForm from = DataForm.from(stanza);
        return (from == null || from.getReportedData() != null) ? null : new Form(from);
    }

    private boolean isFormType() {
        return DataForm.Type.form == this.dataForm.getType();
    }

    private boolean isSubmitType() {
        return DataForm.Type.submit == this.dataForm.getType();
    }

    private void setAnswer(FormField formField, Object obj) {
        if (isSubmitType()) {
            formField.resetValues();
            formField.addValue(obj.toString());
            return;
        }
        throw new IllegalStateException("Cannot set an answer if the form is not of type \"submit\"");
    }

    private static void validateThatFieldIsText(FormField formField) {
        switch (C27851.$SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[formField.getType().ordinal()]) {
            case VideoSize.CIF /*1*/:
            case VideoSize.HVGA /*2*/:
            case Version.API03_CUPCAKE_15 /*3*/:
            default:
                throw new IllegalArgumentException("This field is not of type text (multi, private or single).");
        }
    }

    public void addField(FormField formField) {
        this.dataForm.addField(formField);
    }

    public Form createAnswerForm() {
        if (isFormType()) {
            Form form = new Form(DataForm.Type.submit);
            for (FormField formField : getFields()) {
                if (formField.getVariable() != null) {
                    FormField formField2 = new FormField(formField.getVariable());
                    formField2.setType(formField.getType());
                    form.addField(formField2);
                    if (formField.getType() == Type.hidden) {
                        List arrayList = new ArrayList();
                        for (String add : formField.getValues()) {
                            arrayList.add(add);
                        }
                        form.setAnswer(formField.getVariable(), arrayList);
                    }
                }
            }
            return form;
        }
        throw new IllegalStateException("Only forms of type \"form\" could be answered");
    }

    public DataForm getDataFormToSend() {
        if (!isSubmitType()) {
            return this.dataForm;
        }
        DataForm dataForm = new DataForm(getType());
        for (FormField formField : getFields()) {
            if (!formField.getValues().isEmpty()) {
                dataForm.addField(formField);
            }
        }
        return dataForm;
    }

    public FormField getField(String str) {
        if (str == null || str.equals(BuildConfig.FLAVOR)) {
            throw new IllegalArgumentException("Variable must not be null or blank.");
        }
        for (FormField formField : getFields()) {
            if (str.equals(formField.getVariable())) {
                return formField;
            }
        }
        return null;
    }

    public List<FormField> getFields() {
        return this.dataForm.getFields();
    }

    public String getInstructions() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = this.dataForm.getInstructions().iterator();
        while (it.hasNext()) {
            stringBuilder.append((String) it.next());
            if (it.hasNext()) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public String getTitle() {
        return this.dataForm.getTitle();
    }

    public DataForm.Type getType() {
        return this.dataForm.getType();
    }

    public void setAnswer(String str, double d) {
        FormField field = getField(str);
        if (field == null) {
            throw new IllegalArgumentException("Field not found for the specified variable name.");
        }
        validateThatFieldIsText(field);
        setAnswer(field, Double.valueOf(d));
    }

    public void setAnswer(String str, float f) {
        FormField field = getField(str);
        if (field == null) {
            throw new IllegalArgumentException("Field not found for the specified variable name.");
        }
        validateThatFieldIsText(field);
        setAnswer(field, Float.valueOf(f));
    }

    public void setAnswer(String str, int i) {
        FormField field = getField(str);
        if (field == null) {
            throw new IllegalArgumentException("Field not found for the specified variable name.");
        }
        validateThatFieldIsText(field);
        setAnswer(field, Integer.valueOf(i));
    }

    public void setAnswer(String str, long j) {
        FormField field = getField(str);
        if (field == null) {
            throw new IllegalArgumentException("Field not found for the specified variable name.");
        }
        validateThatFieldIsText(field);
        setAnswer(field, Long.valueOf(j));
    }

    public void setAnswer(String str, String str2) {
        FormField field = getField(str);
        if (field == null) {
            throw new IllegalArgumentException("Field not found for the specified variable name.");
        }
        switch (C27851.$SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[field.getType().ordinal()]) {
            case VideoSize.CIF /*1*/:
            case VideoSize.HVGA /*2*/:
            case Version.API03_CUPCAKE_15 /*3*/:
            case Version.API04_DONUT_16 /*4*/:
            case Version.API05_ECLAIR_20 /*5*/:
                setAnswer(field, (Object) str2);
            default:
                throw new IllegalArgumentException("This field is not of type String.");
        }
    }

    public void setAnswer(String str, List<String> list) {
        if (isSubmitType()) {
            FormField field = getField(str);
            if (field != null) {
                switch (C27851.$SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[field.getType().ordinal()]) {
                    case VideoSize.CIF /*1*/:
                    case Version.API05_ECLAIR_20 /*5*/:
                    case Version.API06_ECLAIR_201 /*6*/:
                    case Version.API07_ECLAIR_21 /*7*/:
                    case Version.API08_FROYO_22 /*8*/:
                        field.resetValues();
                        field.addValues(list);
                        return;
                    default:
                        throw new IllegalArgumentException("This field only accept list of values.");
                }
            }
            throw new IllegalArgumentException("Couldn't find a field for the specified variable.");
        }
        throw new IllegalStateException("Cannot set an answer if the form is not of type \"submit\"");
    }

    public void setAnswer(String str, boolean z) {
        FormField field = getField(str);
        if (field == null) {
            throw new IllegalArgumentException("Field not found for the specified variable name.");
        } else if (field.getType() != Type.bool) {
            throw new IllegalArgumentException("This field is not of type boolean.");
        } else {
            setAnswer(field, z ? "1" : "0");
        }
    }

    public void setDefaultAnswer(String str) {
        if (isSubmitType()) {
            FormField field = getField(str);
            if (field != null) {
                field.resetValues();
                for (String addValue : field.getValues()) {
                    field.addValue(addValue);
                }
                return;
            }
            throw new IllegalArgumentException("Couldn't find a field for the specified variable.");
        }
        throw new IllegalStateException("Cannot set an answer if the form is not of type \"submit\"");
    }

    public void setInstructions(String str) {
        List arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, "\n");
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        this.dataForm.setInstructions(arrayList);
    }

    public void setTitle(String str) {
        this.dataForm.setTitle(str);
    }
}

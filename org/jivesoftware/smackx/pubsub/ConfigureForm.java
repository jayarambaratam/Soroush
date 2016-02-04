package org.jivesoftware.smackx.pubsub;

import java.util.ArrayList;
import java.util.List;
import org.jivesoftware.smackx.xdata.Form;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jivesoftware.smackx.xdata.packet.DataForm.Type;

public class ConfigureForm extends Form {
    public ConfigureForm(Form form) {
        super(form.getDataFormToSend());
    }

    public ConfigureForm(Type type) {
        super(type);
    }

    public ConfigureForm(DataForm dataForm) {
        super(dataForm);
    }

    private void addField(ConfigureNodeFields configureNodeFields, FormField.Type type) {
        String fieldName = configureNodeFields.getFieldName();
        if (getField(fieldName) == null) {
            FormField formField = new FormField(fieldName);
            formField.setType(type);
            addField(formField);
        }
    }

    private String getFieldValue(ConfigureNodeFields configureNodeFields) {
        FormField field = getField(configureNodeFields.getFieldName());
        return field.getValues().isEmpty() ? null : (String) field.getValues().get(0);
    }

    private List<String> getFieldValues(ConfigureNodeFields configureNodeFields) {
        return getField(configureNodeFields.getFieldName()).getValues();
    }

    private List<String> getListSingle(String str) {
        List<String> arrayList = new ArrayList(1);
        arrayList.add(str);
        return arrayList;
    }

    private static boolean parseBoolean(String str) {
        return "1".equals(str) || "true".equals(str);
    }

    public AccessModel getAccessModel() {
        String fieldValue = getFieldValue(ConfigureNodeFields.access_model);
        return fieldValue == null ? null : AccessModel.valueOf(fieldValue);
    }

    public String getBodyXSLT() {
        return getFieldValue(ConfigureNodeFields.body_xslt);
    }

    public List<String> getChildren() {
        return getFieldValues(ConfigureNodeFields.children);
    }

    public ChildrenAssociationPolicy getChildrenAssociationPolicy() {
        String fieldValue = getFieldValue(ConfigureNodeFields.children_association_policy);
        return fieldValue == null ? null : ChildrenAssociationPolicy.valueOf(fieldValue);
    }

    public List<String> getChildrenAssociationWhitelist() {
        return getFieldValues(ConfigureNodeFields.children_association_whitelist);
    }

    public int getChildrenMax() {
        return Integer.parseInt(getFieldValue(ConfigureNodeFields.children_max));
    }

    public String getCollection() {
        return getFieldValue(ConfigureNodeFields.collection);
    }

    public String getDataType() {
        return getFieldValue(ConfigureNodeFields.type);
    }

    public String getDataformXSLT() {
        return getFieldValue(ConfigureNodeFields.dataform_xslt);
    }

    public ItemReply getItemReply() {
        String fieldValue = getFieldValue(ConfigureNodeFields.itemreply);
        return fieldValue == null ? null : ItemReply.valueOf(fieldValue);
    }

    public int getMaxItems() {
        return Integer.parseInt(getFieldValue(ConfigureNodeFields.max_items));
    }

    public int getMaxPayloadSize() {
        return Integer.parseInt(getFieldValue(ConfigureNodeFields.max_payload_size));
    }

    public NodeType getNodeType() {
        String fieldValue = getFieldValue(ConfigureNodeFields.node_type);
        return fieldValue == null ? null : NodeType.valueOf(fieldValue);
    }

    public PublishModel getPublishModel() {
        String fieldValue = getFieldValue(ConfigureNodeFields.publish_model);
        return fieldValue == null ? null : PublishModel.valueOf(fieldValue);
    }

    public List<String> getReplyRoom() {
        return getFieldValues(ConfigureNodeFields.replyroom);
    }

    public List<String> getReplyTo() {
        return getFieldValues(ConfigureNodeFields.replyto);
    }

    public List<String> getRosterGroupsAllowed() {
        return getFieldValues(ConfigureNodeFields.roster_groups_allowed);
    }

    public String getTitle() {
        return getFieldValue(ConfigureNodeFields.title);
    }

    public boolean isDeliverPayloads() {
        return parseBoolean(getFieldValue(ConfigureNodeFields.deliver_payloads));
    }

    public boolean isNotifyConfig() {
        return parseBoolean(getFieldValue(ConfigureNodeFields.notify_config));
    }

    public boolean isNotifyDelete() {
        return parseBoolean(getFieldValue(ConfigureNodeFields.notify_delete));
    }

    public boolean isNotifyRetract() {
        return parseBoolean(getFieldValue(ConfigureNodeFields.notify_retract));
    }

    public boolean isPersistItems() {
        return parseBoolean(getFieldValue(ConfigureNodeFields.persist_items));
    }

    public boolean isPresenceBasedDelivery() {
        return parseBoolean(getFieldValue(ConfigureNodeFields.presence_based_delivery));
    }

    @Deprecated
    public boolean isSubscibe() {
        return isSubscribe();
    }

    public boolean isSubscribe() {
        return parseBoolean(getFieldValue(ConfigureNodeFields.subscribe));
    }

    public void setAccessModel(AccessModel accessModel) {
        addField(ConfigureNodeFields.access_model, FormField.Type.list_single);
        setAnswer(ConfigureNodeFields.access_model.getFieldName(), getListSingle(accessModel.toString()));
    }

    public void setBodyXSLT(String str) {
        addField(ConfigureNodeFields.body_xslt, FormField.Type.text_single);
        setAnswer(ConfigureNodeFields.body_xslt.getFieldName(), str);
    }

    public void setChildren(List<String> list) {
        addField(ConfigureNodeFields.children, FormField.Type.text_multi);
        setAnswer(ConfigureNodeFields.children.getFieldName(), (List) list);
    }

    public void setChildrenAssociationPolicy(ChildrenAssociationPolicy childrenAssociationPolicy) {
        addField(ConfigureNodeFields.children_association_policy, FormField.Type.list_single);
        List arrayList = new ArrayList(1);
        arrayList.add(childrenAssociationPolicy.toString());
        setAnswer(ConfigureNodeFields.children_association_policy.getFieldName(), arrayList);
    }

    public void setChildrenAssociationWhitelist(List<String> list) {
        addField(ConfigureNodeFields.children_association_whitelist, FormField.Type.jid_multi);
        setAnswer(ConfigureNodeFields.children_association_whitelist.getFieldName(), (List) list);
    }

    public void setChildrenMax(int i) {
        addField(ConfigureNodeFields.children_max, FormField.Type.text_single);
        setAnswer(ConfigureNodeFields.children_max.getFieldName(), i);
    }

    public void setCollection(String str) {
        addField(ConfigureNodeFields.collection, FormField.Type.text_single);
        setAnswer(ConfigureNodeFields.collection.getFieldName(), str);
    }

    public void setDataType(String str) {
        addField(ConfigureNodeFields.type, FormField.Type.text_single);
        setAnswer(ConfigureNodeFields.type.getFieldName(), str);
    }

    public void setDataformXSLT(String str) {
        addField(ConfigureNodeFields.dataform_xslt, FormField.Type.text_single);
        setAnswer(ConfigureNodeFields.dataform_xslt.getFieldName(), str);
    }

    public void setDeliverPayloads(boolean z) {
        addField(ConfigureNodeFields.deliver_payloads, FormField.Type.bool);
        setAnswer(ConfigureNodeFields.deliver_payloads.getFieldName(), z);
    }

    public void setItemReply(ItemReply itemReply) {
        addField(ConfigureNodeFields.itemreply, FormField.Type.list_single);
        setAnswer(ConfigureNodeFields.itemreply.getFieldName(), getListSingle(itemReply.toString()));
    }

    public void setMaxItems(int i) {
        addField(ConfigureNodeFields.max_items, FormField.Type.text_single);
        setAnswer(ConfigureNodeFields.max_items.getFieldName(), i);
    }

    public void setMaxPayloadSize(int i) {
        addField(ConfigureNodeFields.max_payload_size, FormField.Type.text_single);
        setAnswer(ConfigureNodeFields.max_payload_size.getFieldName(), i);
    }

    public void setNodeType(NodeType nodeType) {
        addField(ConfigureNodeFields.node_type, FormField.Type.list_single);
        setAnswer(ConfigureNodeFields.node_type.getFieldName(), getListSingle(nodeType.toString()));
    }

    public void setNotifyConfig(boolean z) {
        addField(ConfigureNodeFields.notify_config, FormField.Type.bool);
        setAnswer(ConfigureNodeFields.notify_config.getFieldName(), z);
    }

    public void setNotifyDelete(boolean z) {
        addField(ConfigureNodeFields.notify_delete, FormField.Type.bool);
        setAnswer(ConfigureNodeFields.notify_delete.getFieldName(), z);
    }

    public void setNotifyRetract(boolean z) {
        addField(ConfigureNodeFields.notify_retract, FormField.Type.bool);
        setAnswer(ConfigureNodeFields.notify_retract.getFieldName(), z);
    }

    public void setPersistentItems(boolean z) {
        addField(ConfigureNodeFields.persist_items, FormField.Type.bool);
        setAnswer(ConfigureNodeFields.persist_items.getFieldName(), z);
    }

    public void setPresenceBasedDelivery(boolean z) {
        addField(ConfigureNodeFields.presence_based_delivery, FormField.Type.bool);
        setAnswer(ConfigureNodeFields.presence_based_delivery.getFieldName(), z);
    }

    public void setPublishModel(PublishModel publishModel) {
        addField(ConfigureNodeFields.publish_model, FormField.Type.list_single);
        setAnswer(ConfigureNodeFields.publish_model.getFieldName(), getListSingle(publishModel.toString()));
    }

    public void setReplyRoom(List<String> list) {
        addField(ConfigureNodeFields.replyroom, FormField.Type.list_multi);
        setAnswer(ConfigureNodeFields.replyroom.getFieldName(), (List) list);
    }

    public void setReplyTo(List<String> list) {
        addField(ConfigureNodeFields.replyto, FormField.Type.list_multi);
        setAnswer(ConfigureNodeFields.replyto.getFieldName(), (List) list);
    }

    public void setRosterGroupsAllowed(List<String> list) {
        addField(ConfigureNodeFields.roster_groups_allowed, FormField.Type.list_multi);
        setAnswer(ConfigureNodeFields.roster_groups_allowed.getFieldName(), (List) list);
    }

    public void setSubscribe(boolean z) {
        addField(ConfigureNodeFields.subscribe, FormField.Type.bool);
        setAnswer(ConfigureNodeFields.subscribe.getFieldName(), z);
    }

    public void setTitle(String str) {
        addField(ConfigureNodeFields.title, FormField.Type.text_single);
        setAnswer(ConfigureNodeFields.title.getFieldName(), str);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(getClass().getName() + " Content [");
        for (FormField formField : getFields()) {
            stringBuilder.append('(');
            stringBuilder.append(formField.getVariable());
            stringBuilder.append(':');
            CharSequence stringBuilder2 = new StringBuilder();
            for (String str : formField.getValues()) {
                if (stringBuilder2.length() > 0) {
                    stringBuilder.append(',');
                }
                stringBuilder2.append(str);
            }
            if (stringBuilder2.length() == 0) {
                stringBuilder2.append("NOT SET");
            }
            stringBuilder.append(stringBuilder2);
            stringBuilder.append(')');
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

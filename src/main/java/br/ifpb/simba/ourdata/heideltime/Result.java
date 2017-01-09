package br.ifpb.simba.ourdata.heideltime;

/**
 *
 * @version 1.0
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 07/01/2017 - 12:01:31
 */
class Result {

    private String id;
    private String type;
    private String value;
    private String data;

    @Override
    public String toString() {
        return "SingleTimeValue{" + "id=" + id + ", type=" + type + ", value=" + value + ", data=" + data + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicobject;

/**
 *
 * @author VNHCMLAP-0074
 */
public class FAQ {

    private String id;
    private String name;
    private String content;
    private String ItemId;

    public FAQ() {
    }

    public FAQ(String id, String name, String content, String ItemId) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.ItemId = ItemId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getItemId() {
        return ItemId;
    }

    public void setItemId(String ItemId) {
        this.ItemId = ItemId;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.heideltime;

/**
 *
 * @author wensttay
 */
class Result{
    
    private String id;
    private String type;
    private String value;
    private String data;

    @Override
    public String toString(){
        return "SingleTimeValue{" + "id=" + id + ", type=" + type + ", value=" + value + ", data=" + data + '}';
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getValue(){
        return value;
    }

    public void setValue(String value){
        this.value = value;
    }

    public String getData(){
        return data;
    }

    public void setData(String data){
        this.data = data;
    }
}

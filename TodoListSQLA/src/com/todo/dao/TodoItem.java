package com.todo.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TodoItem {
    private String title;
    private String desc;
    private String current_date;
    private String category;
    private String due_date;
    private int id;
    private int is_completed;
    
	public TodoItem(String category, String title, String desc, String due_date, int is_completed) {
		this.category=category;
        this.title=title;
        this.desc=desc;
        this.due_date=due_date;
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");
        this.current_date= df.format(new Date());
        this.is_completed= is_completed;
    }

	public TodoItem (String category2, String title2, String desc2, String due_date2) {
		this.category=category2;
        this.title=title2;
        this.desc=desc2;
        this.due_date=due_date2;
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");
        this.current_date= df.format(new Date());
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCurrent_date() {
        return current_date;
    }
    
    public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

    public void setCurrent_date(String current_date) {
        this.current_date = current_date;
    }
    
    public String toSaveString() {
    	return category+"##"+title+"##"+desc+"##"+due_date+"##"+current_date+"\n";
    }
    
    public String toCompare() {
    	return title+desc;
    }
     
	@Override
	public String toString() {
		if(is_completed == 0)
			return " ["+category+"] "+title+" - "+desc+" - "+due_date+" - "+current_date;
		else return " ["+category+"] "+title+" [V] - "+desc+" - "+due_date+" - "+current_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id =id;
	}

	public int getIs_completed() {
		return is_completed;
	}

	public void setIs_completed(int is_completed) {
		this.is_completed = is_completed;
	}
	
}
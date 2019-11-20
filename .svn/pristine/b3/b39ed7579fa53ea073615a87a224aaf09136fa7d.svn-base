package com.caishen91.jupiter.util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import com.alibaba.fastjson.JSON;
import com.caishen91.jupiter.model.AuthTree;

public class TreeUtil {

	/**
	 * 把列表转换为树结构
	 *
	 * @param originalList 原始list数据
	 * @param keyName 作为唯一标示的字段名称
	 * @return 组装后的集合
	 */
	public static <T> List<T> getTree(List<T> originalList, String keyName) throws Exception {
	    String parentFieldName = "parentId";
	    String childrenFieldName = "children";

	    // 获取根节点，即找出父节点为空的对象
	    List<T> topList = new ArrayList<>();
	    for (int i = 0; i < originalList.size(); i++) {
	        T t = originalList.get(i);
	        String parentId = BeanUtils.getProperty(t, parentFieldName);
	        if (Integer.valueOf(parentId) == 0) {
	        	BeanUtils.setProperty(t, parentFieldName, null);
	            topList.add(t);
	        }
	    }

	    // 将根节点从原始list移除，减少下次处理数据
	    originalList.removeAll(topList);

	    // 递归封装树
	    fillTree(topList, originalList, keyName, parentFieldName, childrenFieldName);

	    return topList;
	}
	
	/**
	 * 封装树
	 *
	 * @param parentList 要封装为树的父对象集合
	 * @param originalList 原始list数据
	 * @param keyName 作为唯一标示的字段名称
	 * @param parentFieldName 模型中作为parent字段名称
	 * @param childrenFieldName 模型中作为children的字段名称
	 */
	public static <T> void fillTree(List<T> parentList, List<T> originalList, String keyName, String parentFieldName, String childrenFieldName) throws Exception {
	    for (int i = 0; i < parentList.size(); i++) {
	        List<T> children = fillChildren(parentList.get(i), originalList, keyName, parentFieldName, childrenFieldName);
	        if (children.isEmpty()) {
	            continue;
	        }
	        originalList.removeAll(children);
	        fillTree(children, originalList, keyName, parentFieldName, childrenFieldName);
	    }
	}
	
	/**
	 * 封装子对象
	 *
	 * @param parent 父对象
	 * @param originalList 待处理对象集合
	 * @param keyName 作为唯一标示的字段名称
	 * @param parentFieldName 模型中作为parent字段名称
	 * @param childrenFieldName 模型中作为children的字段名称
	 */
	public static <T> List<T> fillChildren(T parent, List<T> originalList, String keyName, String parentFieldName, String childrenFieldName) throws Exception {
	    List<T> childList = new ArrayList<>();
	    String parentId = BeanUtils.getProperty(parent, keyName);
	    for (int i = 0; i < originalList.size(); i++) {
	        T t = originalList.get(i);
	        String childParentId = BeanUtils.getProperty(t, parentFieldName);
	        if (parentId.equals(childParentId)) {
	        	BeanUtils.setProperty(t, parentFieldName, null);
	            childList.add(t);
	        }
	    }
	    if (!childList.isEmpty()) {
	        FieldUtils.writeField(parent, childrenFieldName, childList, true);
	    }
	    return childList;
	}
	
	public static void main(String[] args) throws Exception {
		List<AuthTree> list = new ArrayList<>();

		AuthTree catalog = new AuthTree();
	    String flowId = randomUUID();
	    catalog.setId(flowId);
	    catalog.setTitle("name1");
	    list.add(catalog);

	    catalog = new AuthTree();
	    String flowId2 = randomUUID();
	    catalog.setId(flowId2);
	    catalog.setTitle("name2");
	    catalog.setParentId(flowId);
	    list.add(catalog);

	    catalog = new AuthTree();
	    String flowId3 = randomUUID();
	    catalog.setId(flowId3);
	    catalog.setTitle("name3");
	    catalog.setParentId(flowId);
	    list.add(catalog);

	    catalog = new AuthTree();
	    String flowId4 = randomUUID();
	    catalog.setId(flowId4);
	    catalog.setTitle("name4");
	    catalog.setParentId(flowId);
	    list.add(catalog);

	    catalog = new AuthTree();
	    String flowId5 = randomUUID();
	    catalog.setId(flowId5);
	    catalog.setTitle("name5");
	    catalog.setParentId(flowId2);
	    list.add(catalog);

	    catalog = new AuthTree();
	    String flowId6 = randomUUID();
	    catalog.setId(flowId6);
	    catalog.setTitle("name6");
	    catalog.setParentId(flowId2);
	    list.add(catalog);

	    List<AuthTree> tree = getTree(list, "id");
	    System.out.println(JSON.toJSONString(tree));
	}
	
	public static String randomUUID() {
	    return UUID.randomUUID().toString().replace("-", "");
	}
}

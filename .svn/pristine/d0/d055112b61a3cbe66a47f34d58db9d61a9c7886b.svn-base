package com.caishen91.jupiter.model;



import java.util.ArrayList;
import java.util.List;

import com.caishen91.jupiter.util.StringUtil;

public class SysPermit {
	
	
	/**
	 * 
	 */
	private int id;
	
	private String modleName;
	
	private String action = "";
	
	private int roleId;
	
	private int level;
	
	private int displayseq = 0;
	
	private String type;
	
	private boolean defaultPermit=true; //默认授权，如果为true，则默认是对应角色就有权限，如果为false，必须授权后才会有
	
	private int parentId;
	
	
	private String tag;//显示标志为
	
	private boolean roleKey; //是否是业务权限
	/**
	 * 	权限编号
	 */
	private String authCode;
	
	public boolean isRoleKey() {
		return roleKey;
	}

	public void setRoleKey(boolean roleKey) {
		this.roleKey = roleKey;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	private String rclass;
	
	private String shortCode;
	
	public String getModleName() {
		return modleName;
	}

	public void setModleName(String modleName) {
		this.modleName = modleName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public void setChildrens(List<SysPermit> childrens) {
		this.childrens = childrens;
	}

	 
	public boolean isDefaultPermit() {
		return defaultPermit;
	}

	public void setDefaultPermit(boolean defaultPermit) {
		this.defaultPermit = defaultPermit;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private List<SysPermit> childrens = new ArrayList<SysPermit>();

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getAction() {
		return action;
	}


	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}
	
	/**
	 * 判断该菜单是否绑定url
	 * @return
	 */
	public boolean hasAction(){
		if(StringUtil.isEmpty(action))
			return false;
		return true;
	}
	
	/**
	 * 判断是否一级菜单
	 * @return
	 */
	public boolean isTop(){
		return parentId == 0;
	}
	
	/**
	 * 获取一级菜单的名称,如：modle_name = "产品管理.概述",返回:产品管理
	 * @return
	 */
	public String getTopEx(){
		if(isTop()) return modleName;
		String[] modles = modleName.split("\\.");
		return modles[0];
	}
	
	/**
	 * 获取菜单的父节点,一级菜单直接返回modle_name，否则返回上一个节点名称,
	 * 如：modle_name = "产品管理.概述",返回：产品管理
	 * @return
	 */
	public String getParentModleName(){
		if(isTop()) return modleName;
		String[] modles = modleName.split("\\.");
		return modles[level-2];
	}
	
	/**
	 * 获取权限名称,如：modle_name = “产品管理”，返回：产品管理，modle_name=“产品管理.概述”,返回：概述
	 * @return
	 */
	public String getRealModleName(){
		return modleName;
	}
	
	public String getParentModleNameWithDot(){
		if(isTop())
			return modleName;
		String[] modles = modleName.split("\\.");
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<level-1; i++){
			sb.append(modles[i]).append(".");
		}
		String result = sb.toString();
		if(result.endsWith(".")){
			result = result.substring(0, result.length() - 1);
		}
		return result;
	}
	
	public List<SysPermit> getChildrens(){
		return childrens;
	}
	
	public void addChildren(SysPermit children){
		childrens.add(children);
	}
	
	public void removeChildren(SysPermit children){
		childrens.remove(children);
	}

	public void setDisplayseq(int displayseq) {
		this.displayseq = displayseq;
	}

	public int getDisplayseq() {
		return displayseq;
	}

	public String getRclass() {
		return rclass;
	}

	public void setRclass(String rclass) {
		this.rclass = rclass;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}
}

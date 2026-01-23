package com.avltree.gamingapp;

public class GamingLeaderboard {
	Player root;
	
	int height(Player n) {
		return n==null? 0: n.getHeight();
	}
	
	int balance(Player n) {
		return n==null ? 0 : height(n.left)-height(n.right);
	}
	
	//right rotation
	public Player rightRotate(Player y) {
		Player x=y.left;
		y.left=x.right;
		x.right=y;
		
		y.setHeight(Math.max(height(y.left),height(y.right))+1);
		x.setHeight(Math.max(height(x.left),height(x.right))+1);
		return x;
	}
	
	//left rotation
	public Player leftRotate(Player x) {
		Player y=x.right;
		x.right=y.left;
		y.left=x;
		
		y.setHeight(Math.max(height(y.left),height(y.right))+1);
		x.setHeight(Math.max(height(x.left),height(x.right))+1);
		return y;		
	}
	
	//insert and update player
	public Player insert(Player root,String name,int score) {
		
		if(root==null) {
		System.out.println("player added.");
		return new Player(name,score);
		}
		if(score<root.getScore()) {
			root.left=insert(root.left,name,score);
		}else if(score>root.getScore()) {
			root.right=insert(root.right,name,score);
		}else {
		     return root;
		}
		
		root.setHeight(Math.max(height(root.left),height( root.right))+1);
		
		int b=balance(root);
		if(b>1 && score<root.left.getScore()) {
			return rightRotate(root);
		}
		if(b<-1 && score>root.right.getScore()) {
			return leftRotate(root);
		}
		return root;
	}
	
	//add player
	public void addPlayer(String name,int score) {
		root=insert(root,name,score);
	}
	
	//show top player
	public void showPlayer(Player root) {
		if(root==null) {
			return;
		}
		showPlayer(root.right);
		System.out.println(root);
		showPlayer(root.left);
	}
	
	public void showLeaderboard() {
		System.out.println("\n------Leaderboard------");
		showPlayer(root);
	}
	
	//delete player
	public Player delete(Player root,int score) {
		if(root==null) {
			return null;
		}
		if(score<root.getScore()) {
			root.left=delete(root.left,score);
		}else if(score>root.getScore()) {
			root.right=delete(root.right,score);
		}else {
			if(root.left==null) {
				return root.right;
			}
			if(root.right==null)
				return root.left;
			
			Player temp=root.right;
			while(temp.left!=null) {
				temp=temp.left;
			}
			root.setScore(temp.getScore());
			root.setName(temp.getName());
			
			root.right=delete(root.right,temp.getScore());
		}
		return root;
	}
	
	public void removePlayer(int score) {
		root=delete(root,score);
	}
}

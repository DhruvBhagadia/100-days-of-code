class Post {
	int id;
	int view_count;
	Boolean seen;

	Post(int id, int view_count, Boolean seen){
		this.id = id;
		this.view_count = view_count;
		this.seen = seen;
	}
}

class RemoveDuplicate {
	public static void main (String args[]) {
		int total_number_of_posts = 100;
		Post[] all_posts = new Post[total_number_of_posts+1]; //100 is the total list of posts
		for(int i=1; i <= total_number_of_posts; i++){
			Post new_post = new Post(i, 101-i, false);
			all_posts[i] = new_post;
		}
		for(int i=1; i <= total_number_of_posts; i++){
			System.out.println(all_posts[i].id + " " + all_posts[i].view_count + " " + all_posts[i].seen);
		}
	}
}
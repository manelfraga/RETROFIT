import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Repositories");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);

        Call<List<Repo>> repos = service.listRepos("irega97");

        try {
            List<Repo> result = repos.execute().body();

            for(Repo r:result){
                System.out.println(r);
            }
        }
        catch(Exception e){
            System.out.println("EXCEPTION!!");
            System.out.println(e.toString());
        }
    }
}

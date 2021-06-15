import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

public class Tests {
  private OnlineRecipeDatabase ord;
  private JsonObject obj1,obj2;
  private JsonArray arr1,arr2;

  @Before
  public void setEnv(){
    ord = new OnlineRecipeDatabase();
    try {
      obj1 = ord.getRecipesByDish("artichoke");
      obj2 = ord.getRecipesByIngredients("cheese,mayonnaise");
    }catch(Exception e){
      Assert.fail("Your Methods for getRecipesBy... are throwing an exception when they shouldn't:\n"+e.getMessage());
    }
    arr1 = (JsonArray) obj1.get("results");
    arr2 = (JsonArray) obj2.get("results");

  }

  @Test
  public void testRetrieval() {
    // put your test here
    String list=null;
    int elems = obj1.keySet().size();
    String site = (String)obj1.get("title");
    String oneDish = (String)((JsonObject)arr2.get(0)).get("ingredients");
    list = ord.formatRecipeAsString(obj2);
    Assert.assertEquals("Are you reading/converting the full JSON document?",4,elems);
  }

  @Test
  public void testReturningJsonDocs(){
    Assert.assertTrue("Are your recipes by dish coming as a JsonArray?",arr1.size()>6 && arr1.size()<11);
    Assert.assertTrue("Are your recipes by ingredient coming as a JsonArray?",arr2.size()>6 && arr1.size()<11);
  }

  @Test
  public void testContent(){
    String oneDish = (String)((JsonObject)arr2.get(0)).get("ingredients");
    Assert.assertTrue("Are you sure you are querying the right thing on getRecipe by ingredients?", oneDish.contains("cheese"));
  }
  @Test
  public void testJSONStructure(){
    String site = (String)obj1.get("title");
    String oneDish = (String)((JsonObject)arr2.get(0)).get("ingredients");
    String list = ord.formatRecipeAsString(obj2);
    Assert.assertTrue("Are you returning the full JsonObject?",site.equals("Recipe Puppy"));
    Assert.assertTrue("Are you formatting the Json as String correctly?",list.contains(oneDish));
  }

  @Test
  public void testWriteDoc(){
    String list = ord.formatRecipeAsString(obj2);
    ord.saveRecipes(list,"test.txt");
    try{
      File f = new File("test.txt");
      Assert.assertTrue("Are you sure you are saving a file with the name that comes in the parameter?",f.exists());
      Assert.assertEquals("Are you writing the file as directed?",f.length(),list.length());
    }catch(SecurityException e){
      Assert.fail("Are you saving the file with ANY filename that is passed?");
    }
  }
}
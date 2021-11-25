import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb://127.0.0.1:27017/");

        MongoDatabase db = mongoClient.getDatabase("vemserdbc");
        MongoCollection<Document> alunos = db.getCollection("alunos");

        // insertOne
        Document result = new Document("nome", "Brunno")
                .append("data_nascimento", LocalDate.of(1992, 06, 30))
                .append("curso", new Document("nome", "Matemática"))
                .append("notas", Arrays.asList(8, 7, 9))
                .append("habilidades", Arrays.asList(
                        new Document()
                                .append("nome", "Português")
                                .append("nível", "Fluente"),
                        new Document()
                                .append("nome", "Inglês")
                                .append("nível", "Intermediário")));

        alunos.insertOne(result);

        // updateOne
        Document query = new Document().append("nome", "Rafael");
        Bson updates = Updates.combine(
                Updates.set("nome", "Rafael Atualizado"),
                Updates.set("idade", 30));
        UpdateOptions options = new UpdateOptions().upsert(true);
        UpdateResult result2 = alunos.updateOne(query, updates, options);

        System.out.println("Modified document count: " + result2.getModifiedCount());
        System.out.println("Upserted id: " + result2.getUpsertedId());

        // findOne
        Bson projectionFields = Projections.fields(
                Projections.include("nome", "idade"),
                Projections.excludeId());

        Document doc = alunos.find(eq("nome", "Miguel"))
                .projection(projectionFields)
                .first();

        System.out.println(doc);

        // deleteOne
        Bson query2 = eq("nome", "Rafael Lazzari");
        DeleteResult result3 = alunos.deleteOne(query2);
        System.out.println("Deleted document count: " + result3.getDeletedCount());
    }
}
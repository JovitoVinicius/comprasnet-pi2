import android.content.Context
import com.siasg.comprasnet.ui.adapter.RecyclerAdapter
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset
import java.util.ArrayList

val detalhes: String = ""
val codigo_contrato: ArrayList<String> = ArrayList()
val cpfContratada: ArrayList<String> = ArrayList()
val cnpj_contratada: ArrayList<String> = ArrayList()
val data_assinatura: ArrayList<String> = ArrayList()
val data_inicio_vigencia: ArrayList<String> = ArrayList()
val data_termino_vigencia: ArrayList<String> = ArrayList()
val fundamento_legal: ArrayList<String> = ArrayList()
val identificador: ArrayList<String> = ArrayList()
val licitacao_associada: ArrayList<String> = ArrayList()
val modalidade_licitacao: ArrayList<String> = ArrayList()
val numero: ArrayList<String> = ArrayList()
val numero_aditivo: ArrayList<String> = ArrayList()
val numero_aviso_licitacao: ArrayList<String> = ArrayList()
val numero_processo: ArrayList<String> = ArrayList()
val objeto: ArrayList<String> = ArrayList()
val origem_licitacao: ArrayList<String> = ArrayList()
val uasg: ArrayList<String> = ArrayList()
val valor_inicial: ArrayList<String> = ArrayList()

fun providesComprasLocal(context: Context, filter: Int, search: String): RecyclerAdapter {
    try {
        val obj = JSONObject(loadJSONFromAsset(context))
        val userArray = obj.getJSONArray("contratos")
        for (i in 0 until userArray.length()) {
            val userDetail = userArray.getJSONObject(i)
            codigo_contrato.add(userDetail.getString("codigo_contrato"))
            cpfContratada.add(userDetail.getString("cpfContratada"))
            cnpj_contratada.add(userDetail.getString("cnpj_contratada"))
            data_assinatura.add(userDetail.getString("data_assinatura"))
            data_inicio_vigencia.add(userDetail.getString("data_inicio_vigencia"))
            data_termino_vigencia.add(userDetail.getString("data_termino_vigencia"))
            fundamento_legal.add(userDetail.getString("fundamento_legal"))
            identificador.add(userDetail.getString("identificador"))
            licitacao_associada.add(userDetail.getString("licitacao_associada"))
            modalidade_licitacao.add(userDetail.getString("modalidade_licitacao"))
            numero.add(userDetail.getString("numero"))
            numero_aditivo.add(userDetail.getString("numero_aditivo"))
            numero_aviso_licitacao.add(userDetail.getString("numero_aviso_licitacao"))
            numero_processo.add(userDetail.getString("numero_processo"))
            objeto.add(userDetail.getString("objeto"))
            origem_licitacao.add(userDetail.getString("origem_licitacao"))
            uasg.add(userDetail.getString("uasg"))
            valor_inicial.add(userDetail.getString("valor_inicial"))
        }
    } catch (e: JSONException) {
        e.printStackTrace()
    }

    return RecyclerAdapter(
        context,
        codigo_contrato,
        cpfContratada,
        cnpj_contratada,
        data_assinatura,
        data_inicio_vigencia,
        data_termino_vigencia,
        fundamento_legal,
        identificador,
        licitacao_associada,
        modalidade_licitacao,
        numero,
        numero_aditivo,
        numero_aviso_licitacao,
        numero_processo,
        objeto,
        origem_licitacao,
        uasg,
        valor_inicial,
        detalhes,
        filter,
        search
    )

}
    private fun loadJSONFromAsset(context: Context): String {
    val json: String?
    try {
        val inputStream: InputStream = context.assets.open("contratos.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        val charset: Charset = Charsets.UTF_8
        inputStream.read(buffer)
        inputStream.close()
        json = String(buffer, charset)
    } catch (ex: IOException) {
        ex.printStackTrace()
        return ""
    }
    return json
}
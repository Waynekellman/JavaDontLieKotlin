package wayne.com.javadontliekotlin.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import wayne.com.javadontliekotlin.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MoneyFragment : Fragment() {

    companion object {

        fun newInstance(gameId: Int): MoneyFragment {
            val bundle: Bundle = Bundle.EMPTY
            bundle.putInt("GameId", gameId)
            val moneyFragment = MoneyFragment()
            moneyFragment.arguments = bundle
            return moneyFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_money, container, false)
    }


}

using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace UVnaloga
{
    public partial class Prostornina : Form
    {
        public Prostornina()
        {
            InitializeComponent();
            MaximizeBox = false;
            MinimizeBox = false;
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            comboBox1.Items.Add("Kubični meter");
            comboBox1.Items.Add("Liter");
            comboBox1.Items.Add("Deciliter");
            comboBox1.Items.Add("Kubični centimeter");
            comboBox1.SelectedIndex = 0;

            comboBox2.Items.Add("Kubični meter");
            comboBox2.Items.Add("Liter");
            comboBox2.Items.Add("Deciliter");
            comboBox2.Items.Add("Kubični centimeter");
            comboBox2.SelectedIndex = 0;
        }

        private void RoundButton15_Click(object sender, EventArgs e)
        {
            Dictionary<string, Double> vrednosti = new Dictionary<string, Double>();
            vrednosti.Add("Kubični meter-Kubični meter",1);
            vrednosti.Add("Kubični meter-Liter", 1000);
            vrednosti.Add("Kubični meter-Deciliter", 10000);
            vrednosti.Add("Kubični meter-Kubični centimeter", 1000000);

            vrednosti.Add("Liter-Kubični meter", 0.001);
            vrednosti.Add("Liter-Liter", 1);
            vrednosti.Add("Liter-Deciliter", 10);
            vrednosti.Add("Liter-Kubični centimeter", 1000);

            vrednosti.Add("Deciliter-Kubični meter", 0.0001);
            vrednosti.Add("Deciliter-Liter", 0.1);
            vrednosti.Add("Deciliter-Deciliter", 1);
            vrednosti.Add("Deciliter-Kubični centimeter", 100);

            vrednosti.Add("Kubični centimeter-Kubični meter", 1e-6);
            vrednosti.Add("Kubični centimeter-Liter", 0.001);
            vrednosti.Add("Kubični centimeter-Deciliter", 0.01);
            vrednosti.Add("Kubični centimeter-Kubični centimeter", 1);

            vrednosti.Add("Galon-Galon",1);
            vrednosti.Add("Galon-Kvart", 4);
            vrednosti.Add("Galon-Unča", 128);

            vrednosti.Add("Kvart-Galon", 0.25);
            vrednosti.Add("Kvart-Kvart", 1);
            vrednosti.Add("Kvart-Unča", 32);

            vrednosti.Add("Unča-Galon", 0.0078125);
            vrednosti.Add("Unča-Kvart", 0.03125);
            vrednosti.Add("Unča-Unča", 1);

            vrednosti.Add("Kubični meter-Galon", 264.172);
            vrednosti.Add("Kubični meter-Kvart", 1056.69);
            vrednosti.Add("Kubični meter-Unča", 33814);

            vrednosti.Add("Liter-Galon", 0.264172);
            vrednosti.Add("Liter-Kvart", 1.05669);
            vrednosti.Add("Liter-Unča", 33.814);

            vrednosti.Add("Deciliter-Galon", 0.0264172);
            vrednosti.Add("Deciliter-Kvart", 0.105669);
            vrednosti.Add("Deciliter-Unča", 3.3814);

            vrednosti.Add("Kubični centimeter-Galon", 0.000264172);
            vrednosti.Add("Kubični cenitmeter-Kvart", 0.00105669);
            vrednosti.Add("Kubični centimeter-Unča", 0.033814);

            vrednosti.Add("Galon-Kubični meter", 0.00378541);
            vrednosti.Add("Galon-Liter", 3.78541);
            vrednosti.Add("Galon-Deciliter", 37.8541);
            vrednosti.Add("Galon-Kubični centimeter", 3785.41);

            vrednosti.Add("Kvart-Kubični meter", 0.000946353);
            vrednosti.Add("Kvart-Liter", 0.946353);
            vrednosti.Add("Kvart-Deciliter", 9.46353);
            vrednosti.Add("Kvart-Kubični centimeter", 946.353);

            vrednosti.Add("Unča-Kubični meter", 2.95735e-5);
            vrednosti.Add("Unča-Liter", 0.0295735);
            vrednosti.Add("Unča-Deciliter", 0.295735);
            vrednosti.Add("Unča-Kubični centimeter", 29.5735);

            int smer = puscicaGumb.ImageIndex;

            if (smer == 0)
            {
                String skupaj = comboBox1.Text + "-" + comboBox2.Text;
                Console.WriteLine(skupaj);
                Double vnos = Convert.ToDouble(textBox1.Text);

                Double vrednost = vnos * vrednosti[skupaj];
                textBox2.Text = vrednost.ToString();
            }
            else
            {
                String skupaj = comboBox2.Text + "-" + comboBox1.Text;

                Double vnos = Convert.ToDouble(textBox2.Text);

                Double vrednost = vnos * vrednosti[skupaj];
                textBox1.Text = vrednost.ToString();
            }

        }

        private void RoundButton14_Click(object sender, EventArgs e)
        {
            textBox1.Text = "";
            textBox2.Text = "";
        }

        private void Button1_Click(object sender, EventArgs e)
        {
            comboBox1.Items.Clear();
            comboBox1.Items.Add("Kubični meter");
            comboBox1.Items.Add("Liter");
            comboBox1.Items.Add("Deciliter");
            comboBox1.Items.Add("Kubični centimeter");
            
            comboBox1.SelectedIndex = 0;
        }

        private void Button2_Click(object sender, EventArgs e)
        {
            comboBox1.Items.Clear();
            comboBox1.Items.Add("Galon");
            comboBox1.Items.Add("Kvart");
            comboBox1.Items.Add("Unča");
            comboBox1.SelectedIndex = 0;
        }

        private void Button4_Click(object sender, EventArgs e)
        {
            comboBox2.Items.Clear();
            comboBox2.Items.Add("Kubični meter");
            comboBox2.Items.Add("Liter");
            comboBox2.Items.Add("Deciliter");
            comboBox2.Items.Add("Kubični centimeter");
            
            comboBox2.SelectedIndex = 0;
        }

        private void RoundButton1_Click(object sender, EventArgs e)
        {
            Form1 m = new Form1();
            m.Show();
            this.Hide();
        }

        private void Button3_Click(object sender, EventArgs e)
        {
            comboBox2.Items.Clear();
            comboBox2.Items.Add("Galon");
            comboBox2.Items.Add("Kvart");
            comboBox2.Items.Add("Unča");
            comboBox2.SelectedIndex = 0;
        }

        private void RoundButton11_Click(object sender, EventArgs e)
        {
            if (puscicaGumb.ImageIndex == 0)
            {
                String vrednost = textBox1.Text;

                vrednost = vrednost + "0";
                textBox1.Text = vrednost;
            }
            else
            {
                String vrednost = textBox2.Text;

                vrednost = vrednost + "0";
                textBox2.Text = vrednost;
            }
        }

        private void RoundButton9_Click(object sender, EventArgs e)
        {
            if (puscicaGumb.ImageIndex == 0)
            {
                String vrednost = textBox1.Text;

                vrednost = vrednost + "1";
                textBox1.Text = vrednost;
            }
            else
            {
                String vrednost = textBox2.Text;

                vrednost = vrednost + "1";
                textBox2.Text = vrednost;
            }
        }

        private void RoundButton6_Click(object sender, EventArgs e)
        {
            if (puscicaGumb.ImageIndex == 0)
            {
                String vrednost = textBox1.Text;

                vrednost = vrednost + "2";
                textBox1.Text = vrednost;
            }
            else
            {
                String vrednost = textBox2.Text;

                vrednost = vrednost + "2";
                textBox2.Text = vrednost;
            }
        }

        private void RoundButton5_Click(object sender, EventArgs e)
        {
            if (puscicaGumb.ImageIndex == 0)
            {
                String vrednost = textBox1.Text;

                vrednost = vrednost + "3";
                textBox1.Text = vrednost;
            }
            else
            {
                String vrednost = textBox2.Text;

                vrednost = vrednost + "3";
                textBox2.Text = vrednost;
            }
        }

        private void RoundButton10_Click(object sender, EventArgs e)
        {
            if (puscicaGumb.ImageIndex == 0)
            {
                String vrednost = textBox1.Text;

                vrednost = vrednost + "4";
                textBox1.Text = vrednost;
            }
            else
            {
                String vrednost = textBox2.Text;

                vrednost = vrednost + "4";
                textBox2.Text = vrednost;
            }
        }

        private void RoundButton7_Click(object sender, EventArgs e)
        {
            if (puscicaGumb.ImageIndex == 0)
            {
                String vrednost = textBox1.Text;

                vrednost = vrednost + "5";
                textBox1.Text = vrednost;
            }
            else
            {
                String vrednost = textBox2.Text;

                vrednost = vrednost + "5";
                textBox2.Text = vrednost;
            }
        }

        private void RoundButton4_Click(object sender, EventArgs e)
        {
            if (puscicaGumb.ImageIndex == 0)
            {
                String vrednost = textBox1.Text;

                vrednost = vrednost + "6";
                textBox1.Text = vrednost;
            }
            else
            {
                String vrednost = textBox2.Text;

                vrednost = vrednost + "6";
                textBox2.Text = vrednost;
            }
        }

        private void RoundButton2_Click(object sender, EventArgs e)
        {
            if (puscicaGumb.ImageIndex == 0)
            {
                String vrednost = textBox1.Text;

                vrednost = vrednost + "7";
                textBox1.Text = vrednost;
            }
            else
            {
                String vrednost = textBox2.Text;

                vrednost = vrednost + "7";
                textBox2.Text = vrednost;
            }
        }

        private void RoundButton8_Click(object sender, EventArgs e)
        {
            if (puscicaGumb.ImageIndex == 0)
            {
                String vrednost = textBox1.Text;

                vrednost = vrednost + "8";
                textBox1.Text = vrednost;
            }
            else
            {
                String vrednost = textBox2.Text;

                vrednost = vrednost + "8";
                textBox2.Text = vrednost;
            }
        }

        private void RoundButton3_Click(object sender, EventArgs e)
        {
            if (puscicaGumb.ImageIndex == 0)
            {
                String vrednost = textBox1.Text;

                vrednost = vrednost + "9";
                textBox1.Text = vrednost;
            }
            else
            {
                String vrednost = textBox2.Text;

                vrednost = vrednost + "9";
                textBox2.Text = vrednost;
            }
        }

        private void PuscicaGumb_Click(object sender, EventArgs e)
        {
            if (puscicaGumb.ImageIndex == 1)
            {
                puscicaGumb.ImageIndex = 0;
            }
            else
            {
                puscicaGumb.ImageIndex = 1;
            }
        }

        private void Prostornina_Load(object sender, EventArgs e)
        {

        }

        private void RoundButton12_Click(object sender, EventArgs e)
        {
            if (puscicaGumb.ImageIndex == 0)
            {
                String vrednost = textBox1.Text;

                vrednost = vrednost + ",";
                textBox1.Text = vrednost;
            }
            else
            {
                String vrednost = textBox2.Text;

                vrednost = vrednost + ",";
                textBox2.Text = vrednost;
            }
        }

        private void Button6_Click(object sender, EventArgs e)
        {
            Form1 m = new Form1();
            m.Show();
            this.Hide();
        }

        private void RoundButton13_Click(object sender, EventArgs e)
        {
            if (puscicaGumb.ImageIndex == 0)
            {
                String vrednost = textBox1.Text;

                if (vrednost != "")
                {
                    vrednost = vrednost.Remove(vrednost.Length - 1);
                    if (vrednost.EndsWith(","))
                    {
                        vrednost = vrednost.Remove(vrednost.Length - 1);
                    }
                    textBox1.Text = vrednost;
                }


            }
            else
            {
                String vrednost = textBox2.Text;

                if (vrednost != "")
                {
                    vrednost = vrednost.Remove(vrednost.Length - 1);
                    if (vrednost.EndsWith(","))
                    {
                        vrednost = vrednost.Remove(vrednost.Length - 1);
                    }
                    textBox2.Text = vrednost;
                }


            }
        }

        private void Button5_Click(object sender, EventArgs e)
        {
            int smer = puscicaGumb.ImageIndex;

            if (smer == 0)
            {
                String skupaj = comboBox1.Text + "-" + comboBox2.Text;
                info nov = new info(skupaj, "prostornina");
                nov.Show();
            }
            else
            {
                String skupaj = comboBox2.Text + "-" + comboBox1.Text;
                info nov = new info(skupaj, "prostornina");
                nov.Show();
            }

            this.Hide();
        }

        private void RoundButton16_Click(object sender, EventArgs e)
        {
            int smer = puscicaGumb.ImageIndex;

            if (smer == 0)
            {
                String skupaj = comboBox1.Text + "-" + comboBox2.Text;
                info nov = new info(skupaj, "prostornina");
                nov.Show();
            }
            else
            {
                String skupaj = comboBox2.Text + "-" + comboBox1.Text;
                info nov = new info(skupaj, "prostornina");
                nov.Show();
            }
        }
    }
}

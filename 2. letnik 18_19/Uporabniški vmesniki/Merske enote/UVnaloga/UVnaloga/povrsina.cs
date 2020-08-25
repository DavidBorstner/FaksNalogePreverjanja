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
    public partial class povrsina : Form
    {
        public povrsina()
        {
            InitializeComponent();
            MaximizeBox = false;
            MinimizeBox = false;
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;

            comboBox1.Items.Add("Kvadratni kilometri");
            comboBox1.Items.Add("Hektari");
            comboBox1.Items.Add("Kvadratni metri");
            comboBox1.Items.Add("Kvadratni centimetri");
            comboBox1.SelectedIndex = 0;

            comboBox2.Items.Add("Kvadratni kilometri");
            comboBox2.Items.Add("Hektari");
            comboBox2.Items.Add("Kvadratni metri");
            comboBox2.Items.Add("Kvadratni centimetri");
            comboBox2.SelectedIndex = 0;

        }

        private void Povrsina_Load(object sender, EventArgs e)
        {

        }

        private void Label1_Click(object sender, EventArgs e)
        {

        }

        private void RoundButton1_Click(object sender, EventArgs e)
        {
            Form1 m = new Form1();
            m.Show();
            this.Hide();
        }

        private void Button1_Click(object sender, EventArgs e)
        {
            comboBox1.Items.Clear();
            comboBox1.Items.Add("Kvadratni kilometri");
            comboBox1.Items.Add("Hektari");
            comboBox1.Items.Add("Kvadratni metri");
            comboBox1.Items.Add("Kvadratni centimetri");
            comboBox1.SelectedIndex = 0;
        }

        private void Button4_Click(object sender, EventArgs e)
        {
            comboBox2.Items.Clear();
            comboBox2.Items.Add("Kvadratni kilometri");
            comboBox2.Items.Add("Hektari");
            comboBox2.Items.Add("Kvadratni metri");
            comboBox2.Items.Add("Kvadratni centimetri");
            comboBox2.SelectedIndex = 0;
        }

        private void Button3_Click(object sender, EventArgs e)
        {
            comboBox2.Items.Clear();
            comboBox2.Items.Add("Aker");
            comboBox2.Items.Add("Kvadratna milja");
            comboBox2.SelectedIndex = 0;
        }

        private void Button2_Click(object sender, EventArgs e)
        {
            comboBox1.Items.Clear();
            comboBox1.Items.Add("Aker");
            comboBox1.Items.Add("Kvadratna milja");
            comboBox1.SelectedIndex = 0;
        }

        private void RoundButton14_Click(object sender, EventArgs e)
        {
            textBox1.Text = "";
            textBox2.Text = "";
        }

        private void PuscicaGumb_Click(object sender, EventArgs e)
        {
            if(puscicaGumb.ImageIndex == 1)
            {
                puscicaGumb.ImageIndex = 0;
            }
            else
            {
                puscicaGumb.ImageIndex = 1;
            }
        }

        private void RoundButton15_Click(object sender, EventArgs e)
        {
            Dictionary<string, Double> vrednosti = new Dictionary<string, Double>();
            vrednosti.Add("Kvadratni kilometri-Kvadratni kilometri", 1);
            vrednosti.Add("Kvadratni kilometri-Hektari", 100);
            vrednosti.Add("Kvadratni kilometri-Kvadratni metri", 1000000);
            vrednosti.Add("Kvadratni kilometri-Kvadratni centimetri", 1e+10);

            vrednosti.Add("Hektari-Kvadratni kilometri", 0.01);
            vrednosti.Add("Hektari-Hektari", 1);
            vrednosti.Add("Hektari-Kvadratni metri", 10000);
            vrednosti.Add("Hektari-Kvadratni centimetri", 1e+8);

            vrednosti.Add("Kvadratni metri-Kvadratni kilometri", 1e-6);
            vrednosti.Add("Kvadratni metri-Hektari", 0.0001);
            vrednosti.Add("Kvadratni metri-Kvadratni metri", 1);
            vrednosti.Add("Kvadratni metri-Kvadratni centimetri", 10000);

            vrednosti.Add("Kvadratni centimetri-Kvadratni kilometri", 1e-10);
            vrednosti.Add("Kvadratni centimetri-Hektari", 1e-8);
            vrednosti.Add("Kvadratni centimetri-Kvadratni metri", 0.0001);
            vrednosti.Add("Kvadratni centimetri-Kvadratni centimetri", 1);

            vrednosti.Add("Aker-Aker", 1);
            vrednosti.Add("Aker-Kvadratna milja", 0.0015625);

            vrednosti.Add("Kvadratna milja-Aker", 640);
            vrednosti.Add("Kvadratna milja-Kvadratna milja", 1);

            vrednosti.Add("Kvadratni Kilometri-Aker", 247.105);
            vrednosti.Add("Kvadratni Kilometri-Kvadratna milja", 0.386102);

            vrednosti.Add("Hektar-Aker", 2.47105);
            vrednosti.Add("Hektar-Kvadratna milja", 0.00386102);

            vrednosti.Add("Kvadratni metri-Aker", 0.000247105);
            vrednosti.Add("Kvadratni metri-Kvadratna milja", 3.86102e-7);

            vrednosti.Add("Kvadratni centimetri-Aker", 2.47105e-8);
            vrednosti.Add("Kvadratni centimetri-Kvadratna milja", 3.86102e-11);

            vrednosti.Add("Aker-Kvadratni kilometri", 0.00404686);
            vrednosti.Add("Aker-Hektari", 0.404686);
            vrednosti.Add("Aker-Kvadratni metri", 4046.86);
            vrednosti.Add("Aker-Kvadratni centimetri", 4.047e+7);

            vrednosti.Add("Kvadratna milja-Kvadratni kilometri", 2.58999);
            vrednosti.Add("Kvadratna milja-Hektari", 258.999);
            vrednosti.Add("Kvadratna milja-Kvadratni metri", 2.59e+6);
            vrednosti.Add("Kvadratna milja-Kvadratni centimetri", 2.59e+10);

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

        private void Button5_Click(object sender, EventArgs e)
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
            int smer = puscicaGumb.ImageIndex;

            if (smer == 0)
            {
                String skupaj = comboBox1.Text + "-" + comboBox2.Text;
                info nov = new info(skupaj, "povrsina");
                nov.Show();
            }
            else
            {
                String skupaj = comboBox2.Text + "-" + comboBox1.Text;
                info nov = new info(skupaj, "povrsina");
                nov.Show();
            }
        }

        private void RoundButton1_Click_1(object sender, EventArgs e)
        {
            int smer = puscicaGumb.ImageIndex;

            if (smer == 0)
            {
                String skupaj = comboBox1.Text + "-" + comboBox2.Text;
                info nov = new info(skupaj, "povrsina");
                nov.Show();
            }
            else
            {
                String skupaj = comboBox2.Text + "-" + comboBox1.Text;
                info nov = new info(skupaj, "povrsina");
                nov.Show();
            }
        }
    }
}

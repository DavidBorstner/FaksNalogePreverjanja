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
    public partial class dolzina : Form
    {
        int gumb1 = 1;
        int gumb2 = 1;


        public dolzina()
        {
            InitializeComponent();
            MaximizeBox = false;
            MinimizeBox = false;
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;

            comboBox1.Items.Add("Kilometri");
            comboBox1.Items.Add("Metri");
            comboBox1.Items.Add("Centimetri");
            comboBox1.Items.Add("Milimetri");
            comboBox1.SelectedIndex = 0;

            comboBox2.Items.Add("Kilometri");
            comboBox2.Items.Add("Metri");
            comboBox2.Items.Add("Centimetri");
            comboBox2.Items.Add("Milimetri");
            comboBox2.SelectedIndex = 0;
            MaximizeBox = false;
            MinimizeBox = false;
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;

        }

        private void Dolzina_Load(object sender, EventArgs e)
        {

        }

        private void RoundButton1_Click(object sender, EventArgs e)
        {
            Form1 m = new Form1();
            m.Show();
            this.Hide();
        }

        private void PovrsinaGumb_Click(object sender, EventArgs e)
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

        private void TextBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void Button1_Click(object sender, EventArgs e)
        {

        }

        private void Button10_Click(object sender, EventArgs e)
        {

        }

        private void Button4_Click(object sender, EventArgs e)
        {

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

        private void RoundButton12_Click(object sender, EventArgs e)
        {

        }

        private void RoundButton13_Click(object sender, EventArgs e)
        {

        }

        private void Button1_Click_1(object sender, EventArgs e)
        {
            comboBox1.Items.Clear();
            gumb1 = 1;
            comboBox1.Items.Add("Kilometri");
            comboBox1.Items.Add("Metri");
            comboBox1.Items.Add("Centimetri");
            comboBox1.Items.Add("Milimetri");
            comboBox1.SelectedIndex = 0;
        }

        private void Button2_Click(object sender, EventArgs e)
        {
            comboBox1.Items.Clear();
            gumb1 = 2;
            comboBox1.Items.Add("Milja");
            comboBox1.Items.Add("Jard");
            comboBox1.Items.Add("Cevelj");
            comboBox1.Items.Add("Palec");
            comboBox1.SelectedIndex = 0;
        }

        private void Button4_Click_1(object sender, EventArgs e)
        {
            comboBox2.Items.Clear();
            gumb1 = 1;
            comboBox2.Items.Add("Kilometri");
            comboBox2.Items.Add("Metri");
            comboBox2.Items.Add("Centimetri");
            comboBox2.Items.Add("Milimetri");
            comboBox2.SelectedIndex = 0;
        }

        private void Button3_Click(object sender, EventArgs e)
        {
            comboBox2.Items.Clear();
            gumb1 = 2;
            comboBox2.Items.Add("Milja");
            comboBox2.Items.Add("Jard");
            comboBox2.Items.Add("Cevelj");
            comboBox2.Items.Add("Palec");
            comboBox2.SelectedIndex = 0;
        }

        private void RoundButton9_Click(object sender, EventArgs e)
        {
            if(puscicaGumb.ImageIndex == 0)
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

        private void RoundButton15_Click(object sender, EventArgs e)
        {
            Dictionary<string,Double> vrednosti = new Dictionary<string, Double>();
            vrednosti.Add("Kilometri-Kilometri", 1);
            vrednosti.Add("Kilometri-Metri",1000);
            vrednosti.Add("Kilometri-Centimetri", 100000);
            vrednosti.Add("Kilometri-Milimetri", 1000000);

            vrednosti.Add("Metri-Kilometri", 0.001);
            vrednosti.Add("Metri-Metri", 1);
            vrednosti.Add("Metri-Centimetri", 100);
            vrednosti.Add("Metri-Milimetri", 1000);

            vrednosti.Add("Centimetri-Kilometri", 0.00001);
            vrednosti.Add("Centimetri-Metri", 0.01);
            vrednosti.Add("Centimetri-Centimetri", 1);
            vrednosti.Add("Centimetri-Milimetri", 10);

            vrednosti.Add("Milimetri-Kilometri", 0.000001);
            vrednosti.Add("Milimetri-Metri", 0.001);
            vrednosti.Add("Milimetri-Centimetri", 0.1);
            vrednosti.Add("Milimetri-Milimetri", 1);


            vrednosti.Add("Milja-Milja", 1);
            vrednosti.Add("Milja-Jard",1760);
            vrednosti.Add("Milja-Cevelj", 5280);
            vrednosti.Add("Milja-Palec", 63360);

            vrednosti.Add("Jard-Milja", 0.000568182);
            vrednosti.Add("Jard-Jard", 1);
            vrednosti.Add("Jard-Cevelj", 3);
            vrednosti.Add("Jard-Palec", 36);

            vrednosti.Add("Cevelj-Milja", 0.000189394);
            vrednosti.Add("Cevelj-Jard", 0.333333);
            vrednosti.Add("Cevelj-Cevelj", 1);
            vrednosti.Add("Cevelj-Palec", 12);

            vrednosti.Add("Palec-Milja", 1.57828e-5);
            vrednosti.Add("Palec-Jard", 0.0277778);
            vrednosti.Add("Palec-Cevelj", 0.0833333);
            vrednosti.Add("Palec-Palec", 1);

            vrednosti.Add("Kilometri-Milja", 0.621371);
            vrednosti.Add("Kilometri-Jard", 1093.61);
            vrednosti.Add("Kilometri-Cevelj", 3280.84);
            vrednosti.Add("Kilometri-Palec", 39370.1);

            vrednosti.Add("Metri-Milja", 0.000621371);
            vrednosti.Add("Metri-Jard", 1.09361);
            vrednosti.Add("Metri-Cevelj", 3.28084);
            vrednosti.Add("Metri-Palec", 39.3701);

            vrednosti.Add("Centimetri-Milja", 6.21371e-6);
            vrednosti.Add("Centimetri-Jard", 0.0109361);
            vrednosti.Add("Centimetri-Cevelj", 0.0328084);
            vrednosti.Add("Centimetri-Palec", 0.393701);

            vrednosti.Add("Milimetri-Milja", 6.21371e-7);
            vrednosti.Add("Milimetri-Jard", 0.00109361);
            vrednosti.Add("Milimetri-Cevelj", 0.00328084);
            vrednosti.Add("Milimetri-Palec", 0.0393701);

            vrednosti.Add("Milja-Kilometri", 1.60934);
            vrednosti.Add("Milja-Metri", 1609.34);
            vrednosti.Add("Milja-Centimetri", 160934);
            vrednosti.Add("Milja-Milimetri", 1.609e+6);

            vrednosti.Add("Jard-Kilometri", 0.0009144);
            vrednosti.Add("Jard-Metri", 0.9144);
            vrednosti.Add("Jard-Centimetri", 91.44);
            vrednosti.Add("Jard-Milimetri", 914.4);

            vrednosti.Add("Cevelj-Kilometri", 0.0003048);
            vrednosti.Add("Cevelj-Metri", 0.3048);
            vrednosti.Add("Cevelj-Centimetri", 30.48);
            vrednosti.Add("Cevelj-Milimetri", 304.8);

            vrednosti.Add("Palec-Kilometri", 2.54e-5);
            vrednosti.Add("Palec-Metri", 0.0254);
            vrednosti.Add("Palec-Centimetri", 2.54);
            vrednosti.Add("Palec-Milimetri", 25.4);

            int smer = puscicaGumb.ImageIndex;

            if(smer == 0)
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

        private void ComboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void RoundButton12_Click_1(object sender, EventArgs e)
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

        private void RoundButton16_Click(object sender, EventArgs e)
        {
            int smer = puscicaGumb.ImageIndex;

            if (smer == 0)
            {
                String skupaj = comboBox1.Text + "-" + comboBox2.Text;
                info nov = new info(skupaj, "dolzina");
                nov.Show();
            }
            else
            {
                String skupaj = comboBox2.Text + "-" + comboBox1.Text;
                info nov = new info(skupaj, "dolzina");
                nov.Show();
            }
        }

        private void Button5_Click(object sender, EventArgs e)
        {
            int smer = puscicaGumb.ImageIndex;

            if (smer == 0)
            {
                String skupaj = comboBox1.Text + "-" + comboBox2.Text;
                info nov = new info(skupaj, "dolzina");
                nov.Show();
            }
            else
            {
                String skupaj = comboBox2.Text + "-" + comboBox1.Text;
                info nov = new info(skupaj, "dolzina");
                nov.Show();
            }
        }

        private void RoundButton13_Click_1(object sender, EventArgs e)
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

        private void Label1_Click(object sender, EventArgs e)
        {

        }

        private void RoundButton1_Click_1(object sender, EventArgs e)
        {
            Dictionary<string, Double> vrednosti = new Dictionary<string, Double>();
            vrednosti.Add("Kilometri-Kilometri", 1);
            vrednosti.Add("Kilometri-Metri", 1000);
            vrednosti.Add("Kilometri-Centimetri", 100000);
            vrednosti.Add("Kilometri-Milimetri", 1000000);

            vrednosti.Add("Metri-Kilometri", 0.001);
            vrednosti.Add("Metri-Metri", 1);
            vrednosti.Add("Metri-Centimetri", 100);
            vrednosti.Add("Metri-Milimetri", 1000);

            vrednosti.Add("Centimetri-Kilometri", 0.00001);
            vrednosti.Add("Centimetri-Metri", 0.01);
            vrednosti.Add("Centimetri-Centimetri", 1);
            vrednosti.Add("Centimetri-Milimetri", 10);

            vrednosti.Add("Milimetri-Kilometri", 0.000001);
            vrednosti.Add("Milimetri-Metri", 0.001);
            vrednosti.Add("Milimetri-Centimetri", 0.1);
            vrednosti.Add("Milimetri-Milimetri", 1);


            vrednosti.Add("Milja-Milja", 1);
            vrednosti.Add("Milja-Jard", 1760);
            vrednosti.Add("Milja-Cevelj", 5280);
            vrednosti.Add("Milja-Palec", 63360);

            vrednosti.Add("Jard-Milja", 0.000568182);
            vrednosti.Add("Jard-Jard", 1);
            vrednosti.Add("Jard-Cevelj", 3);
            vrednosti.Add("Jard-Palec", 36);

            vrednosti.Add("Cevelj-Milja", 0.000189394);
            vrednosti.Add("Cevelj-Jard", 0.333333);
            vrednosti.Add("Cevelj-Cevelj", 1);
            vrednosti.Add("Cevelj-Palec", 12);

            vrednosti.Add("Palec-Milja", 1.57828e-5);
            vrednosti.Add("Palec-Jard", 0.0277778);
            vrednosti.Add("Palec-Cevelj", 0.0833333);
            vrednosti.Add("Palec-Palec", 1);

            vrednosti.Add("Kilometri-Milja", 0.621371);
            vrednosti.Add("Kilometri-Jard", 1093.61);
            vrednosti.Add("Kilometri-Cevelj", 3280.84);
            vrednosti.Add("Kilometri-Palec", 39370.1);

            vrednosti.Add("Metri-Milja", 0.000621371);
            vrednosti.Add("Metri-Jard", 1.09361);
            vrednosti.Add("Metri-Cevelj", 3.28084);
            vrednosti.Add("Metri-Palec", 39.3701);

            vrednosti.Add("Centimetri-Milja", 6.21371e-6);
            vrednosti.Add("Centimetri-Jard", 0.0109361);
            vrednosti.Add("Centimetri-Cevelj", 0.0328084);
            vrednosti.Add("Centimetri-Palec", 0.393701);

            vrednosti.Add("Milimetri-Milja", 6.21371e-7);
            vrednosti.Add("Milimetri-Jard", 0.00109361);
            vrednosti.Add("Milimetri-Cevelj", 0.00328084);
            vrednosti.Add("Milimetri-Palec", 0.0393701);

            vrednosti.Add("Milja-Kilometri", 1.60934);
            vrednosti.Add("Milja-Metri", 1609.34);
            vrednosti.Add("Milja-Centimetri", 160934);
            vrednosti.Add("Milja-Milimetri", 1.609e+6);

            vrednosti.Add("Jard-Kilometri", 0.0009144);
            vrednosti.Add("Jard-Metri", 0.9144);
            vrednosti.Add("Jard-Centimetri", 91.44);
            vrednosti.Add("Jard-Milimetri", 914.4);

            vrednosti.Add("Cevelj-Kilometri", 0.0003048);
            vrednosti.Add("Cevelj-Metri", 0.3048);
            vrednosti.Add("Cevelj-Centimetri", 30.48);
            vrednosti.Add("Cevelj-Milimetri", 304.8);

            vrednosti.Add("Palec-Kilometri", 2.54e-5);
            vrednosti.Add("Palec-Metri", 0.0254);
            vrednosti.Add("Palec-Centimetri", 2.54);
            vrednosti.Add("Palec-Milimetri", 25.4);

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
    }
}
